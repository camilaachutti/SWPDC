package swpdc;
import dados.BufferSimples;

/**
 *
 * @author cachutti
 */
public class MainParaVerificacaoDados {
    private static BufferSimples m_bufTta;
   
    public static void main(String[] args){
        float m_buffer[] = {1,3,4,5,6,7,8,9,4,5,6,7};
        Object area = new Object();
        m_bufTta = new BufferSimples(area , (byte)60000);
        m_bufTta.inserir(m_buffer[1], (byte)4, 1);
        float result = m_bufTta.recuperar(0);
        System.out.println(result);
    }
}
