/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suporte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author cachutti
 */
public class Logger {
     // criaArquivo ("log.txt");
    String caminhoAbsoluto = "/Users/cachutti/Desktop/IC/teste/";
    FileWriter arquivoLog = null;
    BufferedWriter bufLog = null;
    
    public Logger () throws IOException{
    
        File log = criaArquivo("log.txt");
        arquivoLog = new FileWriter (log, true);
        bufLog = new BufferedWriter (arquivoLog);
    }
    
    private File criaArquivo (String nomeArquivo){
       
        File arquivo = new File(  caminhoAbsoluto + nomeArquivo );
        if (arquivo.exists()){
            arquivo.delete();
        }
        try {
            arquivo.createNewFile();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo;
    }
    
    public void registrarErro (String erro){
        
         try {
            bufLog.append(erro);
            bufLog.newLine();
            bufLog.flush();
        } catch (IOException ex) {
             java.util.logging.Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
     public void fecharLog (){
       
         try {
            bufLog.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
