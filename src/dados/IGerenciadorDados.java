package dados;

/**
 *
 * @author cachutti
 */
public interface IGerenciadorDados {
    
    // Adiciona dados a um buffer específico, destino - Indicador do buffer de
    // destino, o qual receberá os dados, dado - Ponteiro para o início da área 
    // a ser copiada (inserida) no buffer, tamanho - A quantidade de bytes a ser
    // inserida no buffer. Retorno - status da adição (sucesso ou fracasso)
    public boolean adicionar( TipoBufferEnum destino, int dado, byte tamanho);
        
    //Efetua os procedimentos de iniciação do gerenciador de dados.
    public void iniciar(); 

    //Insere no buffer de relato de eventos um dado evento, juntamente com sua 
    //informação associada, tipo - Indicador do tipo do relato de evento. info -
    //Informação associada ao evento. Deve ser obrigatoriamente um vetor de 5 bytes.
    public void relatarEvento( TipoRelatoEventoEnum tipo, int[] info);

    //Remove dados de um buffer específico, local - Indicador do buffer de
    // origem dos dados a serem removidos, dado - Ponteiro para a área de 
    // memória de destino, o qual serão copiados os bytes removidos do buffer.
    // tamanho - Quantidade de bytes a serem removidos do buffer.
    //retorno - A quantidade de bytes efetivamente removida do buffer.
    public double remover( TipoBufferEnum local, int dado, byte tamanho);


}
