package dados;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import suporte.Comunicador;
import suporte.Verificador;

/**
 *
 * @author cachutti
 */
//Tarefa responsável pela medição das temperaturas nos pontos 1 e 2(portas ADC_C1 
// e ADC_C2 - Canais analógicos para aquisição de temperaturas.).
public class Temperatura {
    
    private BufferSimples m_bufTta; //Referência para o Gerenciador de Dados.
    private float[] m_buffer; //Últimas 12 amostras de cada ponto de leitura de temperatura.
    private int m_ixbuf; //Indexador da próxima posição livre do buffer (circular) de temperaturas.
    Timer timer;
    Comunicador comunicador;
    Verificador verificador;
    int amostraAtual = 1;
    Housekeeper hk = new Housekeeper();
        
    //Ponto de entrada da tarefa.
    
    public Temperatura (){
        m_buffer = new float[12];
        m_bufTta = new BufferSimples(this , (byte)60000);
        comunicador = Comunicador.instanciar();
        verificador = Verificador.instanciar();
        timer = new Timer();
        
    }
    
    public void executar(int seconds){
        timer.scheduleAtFixedRate (new ObterAmostras(), 500 ,seconds*1000);
        
    }

   //Obtém as últimas amostras de temperatura.
    //-1 é colocado no buffer para mostrar que aquela amostra está fora do intervalo admitido
    class ObterAmostras extends TimerTask{
       
        @Override
        public void run (){
            m_bufTta.clear();
            obterERelatarTemperatura();    
        }

        public boolean temperaturaPertenceAoIntevalo(float temperatura) {
            if(temperatura >= 10.0 && temperatura <= 40.0) {
                return true;   
            }
            else{
               System.out.println("temperatura " + temperatura + " fora do intervalo.");
               return false;
              }
        }
   
        private void obterERelatarTemperatura (){
            
            comunicador.emitirComando("OBTER TEMPERATURA");
            
            try {
                Thread.sleep((long)5000); //5 segundo
            } catch (InterruptedException ex) {
                Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Novas amostras de temperatura");
            comunicador.guardarNoHistorico("Obtenção das novas amostras de temperatura");
            m_buffer = verificador.obterAmostras(amostraAtual);
            int todasAmostrasCorretas = 0;
            
            if (m_buffer != null) {
                for (int i = 0; i < 12; i++){
                     System.out.println(m_buffer[i]);
                    if (temperaturaPertenceAoIntevalo (m_buffer[i]) ) {
                        System.out.println("Pertenço ao intervalo");
                        m_bufTta.inserir(m_buffer[i], (byte)4, i);
                        //System.out.println(m_bufTta.recuperar(i));
                      
                    } else{
                        System.out.println("Não Pertenço ao intervalo");
                        m_bufTta.inserir(-1, (byte)4, i);
                        System.out.println(m_bufTta.recuperar(i));
                      
                        todasAmostrasCorretas++;
                    } 
                }
                if (todasAmostrasCorretas == 0){
                    comunicador.guardarNoHistorico("Correto armazenamento da amostra " + amostraAtual + " no buffer.");
                } else {
                    System.out.println("Temperatura fora do intervalo detectada na amostra " + amostraAtual + ".");
                    comunicador.guardarNoHistorico("Foram detectados " + todasAmostrasCorretas + " dados errados durante o armazenamento da amostra " + amostraAtual );
                }
            }else{
                comunicador.guardarNoHistorico("Aguardando amostra...");
                System.out.println("oiiiiiiii");
            }
            
            
            try {
                hk.executar(m_bufTta);
            } catch (IOException ex) {
                Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
            amostraAtual++;
        }
    }
}
