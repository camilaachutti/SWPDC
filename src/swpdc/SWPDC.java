/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swpdc; 

import suporte.IniciadorHW;
import dados.GerenciadorDados;


/**
 *
 * @author cachutti
 */
public class SWPDC {

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        /* A Inicialização foi dividida em 2 fases.A primeira é a POST, que 
         * realiza a verificação de hardware e a segunda é a que ocorre depois
         * e é o relacionada mais oa software */
        IniciadorHW iniciadorHW = new IniciadorHW();
        
        iniciadorHW.iniciar();
        
        iniciarTarefas();
        
        while(true){
            
        }
    }
    
    /**
     * Iniciação das tarefas de regime permanente (classes ativas).
     */
    public static void iniciarTarefas(){
        GerenciadorDados gerenciadorDados = new GerenciadorDados();
        gerenciadorDados.iniciar();
    }
}
