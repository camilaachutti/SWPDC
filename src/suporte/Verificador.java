/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suporte;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cachutti
 */
public class Verificador {
    FileReader arquivoSysInfo = null;
    FileReader arquivoRegistroTemp = null;
    String caminhoAbsoluto = "/Users/cachutti/Desktop/IC/teste/";
    BufferedReader bufReaderSysInfo = null;
    BufferedReader bufReaderRegistroTemp = null;
             
    public Verificador (){
        try {
            arquivoSysInfo = new FileReader(caminhoAbsoluto + "sysInfo.txt");
            bufReaderSysInfo = new BufferedReader(arquivoSysInfo);
            
            arquivoRegistroTemp = new FileReader(caminhoAbsoluto + "registroTemp.txt");
            bufReaderRegistroTemp = new BufferedReader (arquivoRegistroTemp);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    //quando liga
    public boolean verificaStatusAlimentacaoLigado (){
        try {
            String linha = bufReaderSysInfo.readLine();
            
            if (!linha.equals("[status] ligado")) {
                System.out.println("Aguardando PDC ligar...");
                return false;    
            }
          
        } catch (IOException ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
}
    
    public String verificaEstado (){
        try {
            String linha = bufReaderSysInfo.readLine();
            String linhaAnterior = null;
            while (linha !=null){ 
                if (!linha.contains("[modoOp]") && linha != null) {
                    linha = bufReaderSysInfo.readLine();
                } else {
                    linhaAnterior = linha;
                    linha = bufReaderSysInfo.readLine();
                }
            }
            return linhaAnterior.substring(9);
        } catch (IOException ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
}
