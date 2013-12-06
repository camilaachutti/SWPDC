package dados;

/**
 *
 * @author cachutti
 */
public interface IBuffer {

    //Verifica se o buffer está vazio. 1 indica que o buffer está vazio, 0, caso contrário
    public boolean estaVazio();
    // Insere um dado no buffer, dado - Ponteiro para endereço do primeiro byte 
    // do dado a ser inserido no buffer, tamanho - Tamanho do dado a ser inserido
    // no buffer. Retorno - Status da inserção (sucesso ou fracasso). 

    public boolean inserir(float dado, byte tamanho, int index);
    // Remove dados do buffer, dado - Ponteiro para área de destino dos dados a 
    // serem removidos do buffer, tamanho - Quantidade de bytes a serem removidos. 
    // Retorno - A quantidade de bytes efetivamente removida do buffer.    
    public void remover(int tamanho);
    
    // tamnho = tamanho do buffer em bytes.
    public byte tamanho();
}
