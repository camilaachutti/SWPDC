package suporte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author cachutti
 */

public class Comunicador {
   
    String caminhoAbsoluto = System.getProperty("user.dir") + "/src/arquivos/";
    FileWriter arquivoHistW = null;
    FileWriter arquivoInstW = null;
    BufferedWriter bufHistW = null;
    BufferedWriter bufInstW = null;
    LoggerSWPDC log;
    private static Comunicador instancia;
   
    protected Comunicador (){
        try {
            File historico = criaArquivo("historico.txt");
            File instrucoes = criaArquivo("instrucoes.txt" );
            arquivoHistW = new FileWriter (historico, true);
            bufHistW = new BufferedWriter (arquivoHistW);

            arquivoInstW = new FileWriter (instrucoes, true);
            bufInstW = new BufferedWriter (arquivoInstW);
        } catch (IOException ex) {
            log.registrarErro(getDataTime() + "Erro na inicialização do Comunicador.");
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
         }
        
}
    
    public static Comunicador instanciar(){
        if (instancia == null) {
            instancia = new Comunicador();
        }
      return instancia;
    }

    protected Comunicador(BufferedWriter instrucao, BufferedWriter historico) {
        this.bufInstW = instrucao;
        this.bufHistW = historico;
        
    }
    
    private File criaArquivo (String nomeArquivo){
       
        File arquivo = new File(  caminhoAbsoluto + nomeArquivo );
        if (arquivo.exists()){
           arquivo.delete();
        }
        try {
            arquivo.createNewFile();
        } catch (IOException ex) {
            log.registrarErro(getDataTime() + "Erro na criação do arquivo de historico e instrucao");
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo;
    }

    public void emitirComando (String comando){
        
         try {
            bufInstW.append(comando);
            bufInstW.newLine();
            bufInstW.flush();
            guardarNoHistorico(getDataTime() + " emitiu comando: " + comando);
         } catch (IOException ex) {
            log.registrarErro(getDataTime() + "Erro na emissão de comando.");
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
   public void fimDaEmissaoDeComandos (){
       
         try {
            bufInstW.close();
        } catch (IOException ex) {
            log.registrarErro(getDataTime() + "Erro na finalizacao da emissao de comandos.");
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
   public void guardarNoHistorico ( String relatoEvento ){
         try {
            bufHistW.append(getDataTime() + " " + relatoEvento);
            bufHistW.newLine();
            bufHistW.flush();
        } catch (IOException ex) {
            log.registrarErro(getDataTime() + "Erro ao guardar no historico.");
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void fecharHistorico (){
        try {
            bufHistW.close();
        } catch (IOException ex) {
            log.registrarErro(getDataTime() + "Erro no fechamento de arquivo de historico.");
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   protected String getDataTime() {
        DateFormat formatoDataTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS"); 
        Date date = new Date();
        return formatoDataTime.format(date);
    }
         
}
            
         