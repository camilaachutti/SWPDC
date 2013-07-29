package suporte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
   Comunicador instrucoesIniciacao; 
   
    @Override
    public void iniciar() {
        try {
            instrucoesIniciacao = new Comunicador(2);
        } catch (IOException ex) {
            Logger.getLogger(Iniciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        instrucoesIniciacao.emitirComando("COMEÇAR SIMULAÇAO");
    }

    @Override
    public int obterStatusPDC() {  
          instrucoesIniciacao.emitirComando("INFORMAR MODO DE OPERACAO");
          
            return 1;
    }

    @Override
    public int ativarModuloDados() {
        //iniciar gerenciamento de dados
        
        
        return 1;
    }
    
    
    public void gerarRelatoPOST() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
