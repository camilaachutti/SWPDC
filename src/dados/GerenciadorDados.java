package dados;
import java.util.GregorianCalendar;
import suporte.Comunicador;

/**
 *
 * @author cachutti
 */

//Coordena a manipulação de dados dos buffers: científico, diagnóstico,
//housekeeping, carga de dados, descarga de dados e relato de eventos.
//singleton
public class GerenciadorDados implements IGerenciadorDados {

        private BufferSimples m_bufCco; //Buffer simples para armazenamento de temperaturas.
        private BufferSimples m_bufEvt; //Buffer simples (memória não paginada) para relato de eventos.
        private static GerenciadorDados instancia = null;
    
     private GerenciadorDados (){
         
     }
    
     public static GerenciadorDados instanciar(){
        if (instancia == null) {
            instancia = new GerenciadorDados();
        }
      return instancia;
    }

    
    @Override
    public void iniciar() {
        byte capacidade= (byte)1024;
        m_bufEvt = new BufferSimples( this , capacidade);
      
    }

    @Override
    public boolean adicionar(TipoBufferEnum destino, int dado, byte tamanho) {
        boolean evento_adicionado = false; 
        switch (destino) {
            case tbCientifico:
                break;
            case tbDiagnose:
                break;
            case tbTeste:
                break;
            case tbHousekeeping: case tbTemperatura:
                break;
            case tbRelatoEventos:
               evento_adicionado = m_bufEvt.inserir(dado, tamanho, 1);
               evento_adicionado = true;
            default:
                break;
        }
         
        return evento_adicionado;
    }

    @Override
    public void relatarEvento(TipoRelatoEventoEnum tipo, int[] info) {
        int timestamp = getHora();
        RelatoEvento relatoEvento = new RelatoEvento(tipo, info, timestamp);
        relatoEvento.idTipo = tipo;
        relatoEvento.info = info;
        
        
    }

        private int getHora() {  

            // cria um StringBuilder  
            StringBuilder sb = new StringBuilder();  

            // cria um GregorianCalendar que vai conter a hora atual  
            GregorianCalendar d = new GregorianCalendar();  

            // anexa do StringBuilder os dados da hora  
            sb.append( d.get( GregorianCalendar.HOUR_OF_DAY ) );  
            sb.append( d.get( GregorianCalendar.MINUTE ) );  
            sb.append( d.get( GregorianCalendar.SECOND ) );  

            String hora = sb.toString();
            int horaInt = Integer.parseInt(hora);

             return horaInt;
   }

@Override
    public double remover(TipoBufferEnum local, int dado, byte tamanho) {
       byte tamanho_evento_removido; 
        switch (local) {
            case tbCientifico:
                break;
            case tbDiagnose:
                break;
            case tbTeste:
                break;
            case tbHousekeeping: case tbTemperatura:
                break;
            case tbRelatoEventos:
               m_bufEvt.remover(tamanho);
               return (double)tamanho;
            default:
                break;
        }
         
        return 0.0;
    }
}    