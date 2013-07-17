package dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import suporte.Iniciador;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author cachutti
 */

//Tarefa responsável pela geração e formatação de dados de housekeeping.
public class Housekeeper {
    
    //Memória de trabalho para composição do pacote de housekeeping.
    private PacoteHK m_pacHke;
    String caminhoAbsolutoRelatorio = "/Users/cachutti/Desktop/IC/teste/relatorio.txt";
    
    //Ponto de entrada da tarefa.
    
    public void executar() throws IOException{
            
        //prepararPacoteHK();
        formatarRelatorio();
        }
    

    //Executa a preparação do pacote de housekeeping, acessando as origens de 
    //dados para um housekeeping completo, gravando os dados no pacote de 
    //housekeeping interno (m_pacHke).

    private void prepararPacoteHK(){
        
        m_pacHke.amoTta = 0; //Últimas 12 amostras de temperaturas
        m_pacHke.modOpe = 0; //Modo de operação corrente do SWPDC.
        m_pacHke.tempoATual = 0; //Tempo em que é formado o pacote (que será estampado no pacote de housekeeping)
        m_pacHke.tpoAmoTta = 0; //Tempo de amostragem de temperaturas.
       // m_pacHke.ptrCga = 0; //Ponteiro de carga de programas.
       // m_pacHke.qteErrCG = 0; //Quantidade de erros de cão-de-guarda ocorridos desde o último zeramento.
       // m_pacHke.qteErrDup = 0; //Quantidade de erros duplos ocorridos desde o último zeramento.
        m_pacHke.qteErrSim = 0; //Quantidade de erros simples ocorridos desde o último zeramento.
        m_pacHke.relEvt = 0; //Últimos relatos de eventos ocorridos.
       //m_pacHke.staAlmEHX1 = 0; //Status da alimentação do conjunto EPP-HX1.
       //m_pacHke.staAlmEHX2 = 0; //Status da alimentação do conjunto EPP-HX2.
       // m_pacHke.tamanho = 0; //Tamanho dos dados de housekeeping.
       // m_pacHke.tpoHke = 0; //Tempo de housekeeping em segundos.
    }
    
    private void formatarRelatorio () throws IOException{
        try{  
           
            File arquivo = new File( caminhoAbsolutoRelatorio );
            arquivo.createNewFile();
            FileWriter arquivoW = new FileWriter (arquivo); 
            PrintWriter printW = new PrintWriter (arquivoW);  
            printW.println("Relatorio PacoteHK");
            printW.println();
            printW.println("[data] " + getData() + "      [hora] " + getTime());
            printW.flush();
            printW.close();
        } catch (IOException e) {
            Logger.getLogger(Iniciador.class.getName()).log(Level.SEVERE, null, e);
        }
        
       
    }
    
    private String getData() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
