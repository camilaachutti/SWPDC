package suporte;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cachutti
 */
public class Iniciador implements IIniciador{

   /*indicam sucessos e fracassos */
   private int m_relPOST = 1;
   private int staMemPrg = 1;
   private int staMemDdo = 1; 
   String caminhoAbsoluto = "/Users/cachutti/Desktop/IC/teste/";
    
    @Override
    public int iniciar() {
        verificarHW();
        iniciarArquivos();
        return 1; 
    }
   
    private void verificarHW(){
       //inicializar o simulador.
       // hw sempre estará em perfeitas condições a título de teste
        
    }
    
    private void iniciarArquivos(){
        criaArquivo ("log.txt");
        criaArquivo("atual.txt");
        criaArquivo("historico.txt");
        criaArquivo("instrucoes.txt" );
         
    }
    
    private void criaArquivo (String nomeArquivo){
       
        File arquivo = new File(  caminhoAbsoluto + nomeArquivo );
        if (arquivo.exists()){
            arquivo.delete();
        }
        try {
            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Iniciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  

}
