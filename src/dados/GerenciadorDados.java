/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author cachutti
 */

//Coordena a manipulação de dados dos buffers: científico, diagnóstico,
//housekeeping, carga de dados, descarga de dados e relato de eventos.
public class GerenciadorDados implements IGerenciadorDados {

      private IBufferVirtual m_bufCco; //Buffer virtual para dados científicos.
      private IBufferVirtual m_bufCga; //Buffer virtual para carga de dados/programas.
      private IBufferVirtual m_bufDge; //Buffer virtual para dados de diagnóstico.
      private IBufferVirtual m_bufDmp; // Buffer virtual para descarga de dados - dump.
      private IBufferSimples m_bufEvt; //Buffer simples (memória não paginada) para relato de eventos.
      private IBufferVirtual m_bufHke; //Buffer virtual para dados de housekeeping.
      private IBufferVirtual m_bufTstHX1; //Buffer virtual para ados de teste da EPP HX1.
      private IBufferVirtual m_bufTstHX2; //Buffer virtual para dados de teste da EPP HX2.
      private MemoriaVirtual m_memCco; //Região de memória virtual para dados científicos.
      private MemoriaVirtual m_memCga; //Região de memória virtual para carga de dados/programa.
      private MemoriaVirtual m_memDge; //Região de memória virtual para dados de diagnóstico.
      private MemoriaVirtual m_memDmp; //Região de memória virtual para descarga de dados - dump.
      private MemoriaVirtual m_memHke; //Região de memória virtual para dados de housekeeping.
      private MemoriaVirtual m_memRelEvt; //Área de memória para os relatos de eventos.
      private MemoriaVirtual m_memTstHX1; //Região de memória virtual para dados de teste da EPP HX1.
      private MemoriaVirtual m_memTstHX2; //Região de memória virtual para dados de teste da EPP HX2.
    
    
    
    @Override
    public double adicionar(int destino, int dado, double tamanho) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void altBufDmp(double endInicial, double endFinal) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void altEnderecoInicialDmp(double endInicial) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void altSelecaoMemDmp(int mem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void iniciar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void iniciarCga(double endereco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void iniciarDgeHx2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void iniciarDmp() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void iniciarTst() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double obtEnderecoInicialDmp() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int obtSelecaoMemDmp() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double obterCSR(int subtipo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int obterUltimoIdHx() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void relatarEvento(int tipo, int[] info) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double remover(int local, int dado, double tamanho) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
