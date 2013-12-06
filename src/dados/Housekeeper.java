package dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import suporte.Iniciador;
/**
 *
 * @author cachutti
 */

//Tarefa responsável pela geração e formatação de dados de housekeeping.
public class Housekeeper {
    
    //Memória de trabalho para composição do pacote de housekeeping.
    private PacoteHK m_pacHke;
    String caminhoAbsolutoRelatorio = System.getProperty("user.dir") + "/src/arquivos/";
    int i = 0;
    //Ponto de entrada da tarefa.
    
    public void executar(BufferSimples buffer) throws IOException{
        
        prepararPacoteHK();
        //buffer.clear();
        prepararTemperaturas(buffer);
        formatarRelatorio();
        }
    
    //Executa a preparação do pacote de housekeeping, acessando as origens de 
    //dados para um housekeeping completo, gravando os dados no pacote de 
    //housekeeping interno (m_pacHke).
    private void prepararPacoteHK(){
        String modOpe = "Nominal"; //Modo de operação corrente do SWPDC.
        String tpoAmoTta = "0"; //Tempo de amostragem de temperaturas.
        int qteErrSim = 0; //Quantidade de erros simples ocorridos desde o último zeramento.
        TipoRelatoEventoEnum relEvt = TipoRelatoEventoEnum.treBufDdoCco10; //Últimos relatos de eventos ocorridos.
        
        m_pacHke = new PacoteHK( modOpe, qteErrSim, relEvt, tpoAmoTta);
        i++;
        m_pacHke.amoTta [0] = 0;
        m_pacHke.amoTta [1] = 1;
        m_pacHke.amoTta [2] = 2;
        m_pacHke.amoTta [3] = 3;
        m_pacHke.amoTta [4] = 4;
        m_pacHke.amoTta [5] = 5;
        m_pacHke.amoTta [6] = 6;
        m_pacHke.amoTta [7] = 7;
        m_pacHke.amoTta [8] = 8;
        m_pacHke.amoTta [9] = 9;
        m_pacHke.amoTta [10] = 10;
        m_pacHke.amoTta [11] = 11;
        
    }
    
    private void formatarRelatorio () throws IOException{
        try{  
           
            File arquivo = new File( caminhoAbsolutoRelatorio + "relatorioHK" + i + ".txt" );
            arquivo.createNewFile();
            FileWriter arquivoW = new FileWriter (arquivo); 
            PrintWriter printW = new PrintWriter (arquivoW);  
            printW.println("Relatorio PacoteHK");
            printW.println();
            printW.println("[data] " + getData() + "      [hora] " + getTime());
            printW.println("[modoOpSWPDC] " + m_pacHke.modOpe);
            printW.println(); 
            printW.println("Amostras de temperaturas");
            printW.println(m_pacHke.amoTta[0]);
            printW.println(m_pacHke.amoTta[1]);
            printW.println(m_pacHke.amoTta[2]);
            printW.println(m_pacHke.amoTta[3]);
            printW.println(m_pacHke.amoTta[4]);
            printW.println(m_pacHke.amoTta[5]);
            printW.println(m_pacHke.amoTta[6]);
            printW.println(m_pacHke.amoTta[7]);
            printW.println(m_pacHke.amoTta[8]);
            printW.println(m_pacHke.amoTta[9]);
            printW.println(m_pacHke.amoTta[10]);
            printW.println(m_pacHke.amoTta[11]);
            printW.println(m_pacHke.qteErrSim + " Erros");
            m_pacHke.tpoAmoTta = getTime();
            printW.println("Intervalo de amostragem: 10s"   );
            printW.println();
            printW.println("Historico eventos");
            printW.println(m_pacHke.relEvt);
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
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SS");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void prepararTemperaturas(BufferSimples buffer) {
       for (int j = 0; j < 12; j++) {
           if (buffer.recuperar(j) == -1.0){
                System.out.println ("FORA DO INTERVALO CERTO");
                m_pacHke.amoTta[j] = (float)-1.0;
                m_pacHke.qteErrSim++;
            }
            m_pacHke.amoTta[j] = (float)buffer.recuperar(j);
      }
    
   }
}
