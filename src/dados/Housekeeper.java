package dados;

/**
 *
 * @author cachutti
 */

//Tarefa responsável pela geração de dados de housekeeping.
public class Housekeeper {
    
    //Memória de trabalho para composição do pacote de housekeeping.
    private PacoteHK m_pacHke;
    
    //Ponto de entrada da tarefa.
    
    public void executar(){
        
    }

    //Executa a preparação do pacote de housekeeping, acessando as origens de 
    //dados para um housekeeping completo, gravando os dados no pacote de 
    //housekeeping interno (m_pacHke).

    private void prepararPacoteHK(){
        
        
        m_pacHke.amoTta = 0; //Últimas 120 amostras de temperaturas, 60 amostras
                        //por cada ponto (1 e 2), intercalados (10 bits por amostra).
        m_pacHke.modOpe = 0; //Modo de operação corrente do SWPDC.
        m_pacHke.ptrCga = 0; //Ponteiro de carga de programas.
        m_pacHke.qteErrCG = 0; //Quantidade de erros de cão-de-guarda ocorridos desde o último zeramento.
        m_pacHke.qteErrDup = 0; //Quantidade de erros duplos ocorridos desde o último zeramento.
        m_pacHke.qteErrSim = 0; //Quantidade de erros simples ocorridos desde o último zeramento.
        m_pacHke.relEvt = 0; //Últimos relatos de eventos ocorridos.
        //m_pacHke.staAlmEHX1 = 0; //Status da alimentação do conjunto EPP-HX1.
        //m_pacHke.staAlmEHX2 = 0; //Status da alimentação do conjunto EPP-HX2.
        m_pacHke.tamanho = 0; //Tamanho dos dados de housekeeping.
        m_pacHke.tempoATual = 0; //Tempo em que é formado o pacote (que será estampado no pacote de housekeeping)
        m_pacHke.tpoAmoTta = 0; //Tempo de amostragem de temperaturas.
        m_pacHke.tpoHke = 0; //Tempo de housekeeping em segundos.
    }

}
