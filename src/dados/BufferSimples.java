package dados;

import java.nio.ByteBuffer;
import java.util.NoSuchElementException;
/**
 *
 * @author cachutti
 */
//buffer circular
public final class BufferSimples implements IBufferSimples, IBuffer {

    private Object m_area; //"Ponteiro" para a área de dados alocada para este buffer.
    private int m_ixrd; //Indexador de leitura do buffer. head
    private int m_ixwr; //Indexador de escrita do buffer. tail
    private byte m_tamanho; //Tamanho, em bytes, da área de dados alocada
    public ByteBuffer buffer;
   
    public BufferSimples (Object area, byte tamanho){
       m_tamanho = tamanho;
       m_area = area;
       alocar (area, tamanho );
       m_ixwr = buffer.position();
       m_ixrd = 0;    
    }
    
    @Override
    public void alocar(Object area, byte tamanho) {
        buffer = ByteBuffer.allocate((int)tamanho);
        buffer.clear();
        System.out.println("Alocação no Buffer de tamanho " + tamanho + " registrada");
    }

    @Override
    public boolean estaVazio() {
        if (m_ixwr == 0) {
            return true;
        }   
        return false;
    }
   

    @Override
    public boolean inserir(float dado, byte tamanho, int index){            
      
        int posicaoInicial;
        int posicaoFinal;
        byte bytesInseridos = 0;
        
        try{
            System.out.println("inseriiii");
             posicaoInicial = buffer.position();
             System.out.println("Dado: " + dado);     
             buffer = buffer.putFloat( dado);
             System.out.println("Dado: " + buffer.getFloat(4));     
        
             m_ixwr = buffer.position();
        }catch(Exception e){
            System.out.println("oioioioioio");
            return false;
        }
       return true;
    }
    
    
    public float recuperar(int index) {             
        if (m_ixwr == 0) {  
                throw new NoSuchElementException();  
           }
        int posicaoFinal;
        float dadoRecuperado = 0;
        
        posicaoFinal = buffer.position();
        
        if (posicaoFinal/4 < index){
           System.out.println("Temperatura número: " + index + " não pode ser recuperada.");
           throw new NoSuchElementException();
        }
        else{
        dadoRecuperado = buffer.getFloat(index*4);
        }
        
        System.out.println ("Dado recuperado " + dadoRecuperado + " posição " + buffer.position());
      
        return dadoRecuperado;
    }
                      
    @Override
    public void remover(int tamanho) {
        System.out.println(buffer.position());        
        buffer.clear();
        buffer.put(new byte[tamanho]);
        buffer.clear();
    }
           
    @Override
    public byte tamanho() {
        return (byte) buffer.capacity();
    }
    
    public int posicao(){
        return buffer.position();
    }
    
    void clear() {
       buffer.rewind();
    }


}
