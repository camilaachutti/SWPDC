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
//singleton
public class Verificador {
    FileReader arquivoSysInfo = null;
    FileReader arquivoRegistroTemp = null;
    String caminhoAbsoluto = "/Users/cachutti/Desktop/IC/teste/";
    BufferedReader bufReaderSysInfo = null;
    BufferedReader bufReaderRegistroTemp = null;
    private static Verificador instancia = null;
    Comunicador comunicador; 
           
    private Verificador (){
        try {
            arquivoSysInfo = new FileReader(caminhoAbsoluto + "sysInfo.txt");
            bufReaderSysInfo = new BufferedReader(arquivoSysInfo);
            
            arquivoRegistroTemp = new FileReader(caminhoAbsoluto + "registroTemp.txt");
            bufReaderRegistroTemp = new BufferedReader (arquivoRegistroTemp);
            
            comunicador = Comunicador.instanciar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
   public static Verificador instanciar(){
        if (instancia == null) {
            instancia = new Verificador();
        }
      return instancia;
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
    // olhar para qdo o munAmostras atual tem 2 digitos
   public float[] obterAmostras (int numAmostraAtual){
      
     
      float[] amostras = null;
      try {
            amostras = new float[13];
            String linha = bufReaderRegistroTemp.readLine();

            System.out.println(linha);
          
           if (linha == null || (linha.contains("[numAm]") && !EhAmostraAtual(numAmostraAtual, linha)) ) {
                System.out.println("Arquivo de registro de amostras desatualizado!");
                comunicador.guardarNoHistorico("Arquivo de amostras desatualizado");
                return null;
                } 
            
            if (!linha.contains("[numAm]") && linha != null) {
                System.out.println("Arquivo de registro de amostras errado!");
                comunicador.guardarNoHistorico("Problema no arquivo de amostras");
                return null;
            }
                
            if (linha.contains("[numAm]") && EhAmostraAtual(numAmostraAtual, linha) ) {
                System.out.println("LinhaAnterior" + linha);
                amostras = organizarAmostrar (linha);   
            }
        } catch (IOException ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       System.out.println("Amostras obtidas com sucesso");
       comunicador.guardarNoHistorico("Amostras obtidas com sucesso");
       return amostras;
       
   }

    private float[] organizarAmostrar(String amostras) {
            String valores = null;
            float[] temperaturas = new float[12];
            valores = amostras.substring(18);
          
            for(int i = 0, j = 0; i < 12; i++, j +=6){
                temperaturas[i] = Float.parseFloat(valores.substring(j, j+4 ));
                System.out.println(temperaturas[i]);
            }
            
            return temperaturas;
    
    }

    private boolean EhAmostraAtual(int numAmostraAtual, String linha) {
        float numAmostra;
        
        numAmostra = Float.parseFloat(linha.substring(8, 9));
        if (numAmostra == numAmostraAtual){
            return true;
        } else{
            return false;
        }
           
    }
}
