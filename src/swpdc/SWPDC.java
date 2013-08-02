package swpdc; 

import dados.GerenciadorDados;
import dados.Housekeeper;
import dados.Temperatura;
import java.io.IOException;
import suporte.Iniciador;

/**
 *
 * @author cachutti
 */
public class SWPDC {

     private static GerenciadorDados gerenciadorDados;
     private static int estadoPDC;
     Iniciador iniciador;
     Housekeeper hk;
       
    public static void main(String[] args) throws IOException {
        /* A Inicialização foi dividida em 2 fases.A primeira é a POST, que 
         * realiza a verificação de hardware -> excluido e a segunda é a que ocorre depois
         * e é o relacionada mais oa software */
        Iniciador iniciador = new Iniciador();
        Housekeeper hk = new Housekeeper();
        
        iniciador.iniciar();
        if (iniciador.m_relPOST == 1){
           estadoPDC = iniciador.obterEstadoPDC();
        }
        
        if (estadoPDC == 1){
            iniciador.ativarModuloDados();
        }
        //hk.executar();\
        
        Temperatura temp = new Temperatura();
        temp.executar(10);
       
        //iniciarTarefas();
    }
    
    /**
     * Iniciação das tarefas de regime permanente (classes ativas).
     */
    public static void iniciarTarefas(){
       
        gerenciadorDados = GerenciadorDados.instanciar();
        gerenciadorDados.iniciar();
        
        //while (true){
            
            
        
        
        
        
        //}
    }
}
