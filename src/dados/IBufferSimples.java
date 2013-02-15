/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author cachutti
 */

//Interface para buffers que manipulam memória de área comum a todas
//páginas (memória estática, não paginada).
public interface IBufferSimples {
    
    //Registra a alocação de uma área de memória para ser manipulada pelo buffer.
    //area - Ponteiro para o início da memória alocada
    //tamanho - Tamanho da área alocada a ser registrada.
  
    public void alocar( void area, double tamanho);
    
    
}
