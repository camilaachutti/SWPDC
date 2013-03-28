package dados;

/**
 *
 * @author cachutti
 */
//Tarefa responsável pela medição das temperaturas nos pontos 1 e 2(portas ADC_C1 
// e ADC_C2 - Canais analógicos para aquisição de temperaturas.).
public class Temperatura {
    
    private BufferSimples m_bufTta; //Referência para o Gerenciador de Dados.
    private int m_buffer; //Últimas 60 amostras de cada ponto de leitura de temperatura.
    private int m_ixbuf; //Indexador da próxima posição livre do buffer (circular) de temperaturas.
    
    //Ponto de entrada da tarefa.
    
    public void executar(){
        int canal = 1; // os canais possíveis são 1 e 2
        
        iniciarCanal( canal);
        lerTemperatura(canal);
    }

    //Inicia canal ADC.
    //canal - Canal ADC usado para ler a temperatura (ponto para amostrar
    //digitalmente a tensão aplicada no canal).
    private void iniciarCanal(int canal){
        
    }
    
   //Lê a temperatura. 
   //canal - Canal ADC usado para ler a temperatura (ponto para amostrar
   //digitalmente a tensão aplicada no canal).
   //retorno - Valor digital correspondente a tensão lida do conversor AD no canal especificado.
   private int lerTemperatura(int canal){
       return 1;
   }
   
   //Obtém as últimas amostras de temperaturas, formatadas em 10 bits por amostra.
   //buf - Ponteiro para um vetor de tamanho fixo de 150 bytes, para comportas as 
   // últimas amostras 160 de temperaturas, em 10 bits por amostra.
    public void obterAmostras(int[] buf){
       
   }
}
