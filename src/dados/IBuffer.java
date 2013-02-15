package dados;

/**
 *
 * @author cachutti
 */
public interface IBuffer {

    //Verifica se o buffer está vazio. 1 indica que o buffer está vazio, 0, caso contrário
    public int estaVazio();
 
    // Insere um dado no buffer, dado - Ponteiro para endereço do primeiro byte 
    // do dado a ser inserido no buffer, tamanho - Tamanho do dado a ser inserido
    // no buffer. Retorno - A quantidade de dados efetivamente gravada no buffer. 

    public double inserir(int dado, double tamanho);
            
    // Remove dados do buffer, dado - Ponteiro para área de destino dos dados a 
    // serem removidos do buffer, tamanho - Quantidade de bytes a serem removidos. 
    // Retorno - A quantidade de bytes efetivamente removida do buffer.    

    public double remover(int dado, double tamanho);
    
    //o Descrição - Retorna o tamanho do buffer.
    // Retorno - O tamanho do buffer em bytes.

    public long tamanho();
}
