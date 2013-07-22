package swpdc; 

import dados.GerenciadorDados;
import dados.Housekeeper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import suporte.Iniciador;

/**
 *
 * @author cachutti
 */
public class SWPDC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /* A Inicialização foi dividida em 2 fases.A primeira é a POST, que 
         * realiza a verificação de hardware e a segunda é a que ocorre depois
         * e é o relacionada mais oa software */
        Iniciador iniciador = new Iniciador();
        Housekeeper hk = new Housekeeper();
        
        iniciador.iniciar();
        hk.executar();
        iniciarTarefas();
    }
    
    /**
     * Iniciação das tarefas de regime permanente (classes ativas).
     */
    public static void iniciarTarefas(){
        GerenciadorDados gerenciadorDados = new GerenciadorDados();
        gerenciadorDados.iniciar();
        
        while (true){
            
            
        
        
        
        
        }
    }
}
