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
import java.util.logging.Logger;

/**
 *
 * @author cachutti
 */
public class Comunicador {
   
    String caminhoAbsoluto = "/Users/cachutti/Desktop/IC/teste/";
    FileWriter arquivoHistW = null;
    FileWriter arquivoInstW = null;
    BufferedWriter bufHistW = null;
    BufferedWriter bufInstW = null;
  
    // tipoArquivo = 1 -> historico
    // tipoArquivo = 2 -> instrução
    public Comunicador ( int tipoArquivo) throws IOException{
       
      switch( tipoArquivo )
        {
        case 1:
                File historico = criaArquivo("historico.txt");
                arquivoHistW = new FileWriter (historico, true);
                bufHistW = new BufferedWriter (arquivoHistW);
                break;

        case 2: 
                File instrucoes = criaArquivo("instrucoes.txt" );
                arquivoInstW = new FileWriter (instrucoes, true);
                bufInstW = new BufferedWriter (arquivoInstW);
                break;
        default:
               System.out.println("Tipo de arquivo escolhido não existe");
        }
                    
    }
        
    private File criaArquivo (String nomeArquivo){
       
        File arquivo = new File(  caminhoAbsoluto + nomeArquivo );
        if (arquivo.exists()){
            arquivo.delete();
        }
        try {
            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Iniciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo;
    }

    public void emitirComando (String comando){
        
         try {
            bufInstW.append(comando);
            bufInstW.newLine();
            bufInstW.flush();
        } catch (IOException ex) {
             Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
     public void fimDaEmissaoDeComandos (){
       
         try {
            bufInstW.close();
        } catch (IOException ex) {
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
   public void guardarNoHistorico ( String relatoEvento ){
         try {
            bufHistW.append( relatoEvento);
            bufHistW.newLine();
            bufHistW.flush();
        } catch (IOException ex) {
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void fecharHistorico (){
        try {
            bufHistW.close();
        } catch (IOException ex) {
            Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
         
}
            
         