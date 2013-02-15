/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author cachutti
 */
public class BufferSimples implements IBufferSimples {

    
    private int m_area; //Ponteiro para a área de dados alocada para este buffer.
    private double m_ixrd; //Indexador de leitura do buffer.
    private double m_ixwr; //Indexador de escrita do buffer.
    private double m_tamanho; //Tamanho da em bytes da área de dados alocada
    
    @Override
    public void alocar(void area, double tamanho) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
       
}
