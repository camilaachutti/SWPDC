package suporte;

/**
 *
 * @author cachutti
 */

public class Iniciador implements IIniciador{

   /*indicam sucessos e fracassos */
   public int m_relPOST = 1;
   Comunicador comunicador; 
   Verificador verificador;
  
   public Iniciador (){
      this(Comunicador.instanciar(), Verificador.instanciar());
   }
  
   protected Iniciador(Comunicador comunicador, Verificador verificador) {
        this.comunicador = comunicador;
        this.verificador = verificador;
   }
   
    @Override
    public void iniciar() {
        
        comunicador.emitirComando("COMEÇAR SIMULAÇAO");
        
        while (!verificador.verificaStatusAlimentacaoLigado()){
            comunicador.guardarNoHistorico("Aguardando PDC ligar.");
            m_relPOST = 0;
        }
        
        comunicador.guardarNoHistorico("PDC inicializado com sucesso.");
        m_relPOST = 1;
    }

    @Override
    public int obterEstadoPDC() {  
        String estado;
        
        comunicador.emitirComando("INFORMAR ESTADO");
        estado = verificador.verificaEstado();
        comunicador.guardarNoHistorico("Verificação de estado do PDC realizada com sucesso - status: " + estado );
        
        if(estado.equals("nominal")) {
            comunicador.guardarNoHistorico("PDC está no estado NOMINAL. Inicialização bem sucedida"); 
            return 1;
        }
        comunicador.guardarNoHistorico("PDC NÃO está no estado NOMINAL.");
        return 0;
    }

    public void finalizar(){
        comunicador.fecharHistorico();
        comunicador.fimDaEmissaoDeComandos();        
    }
    
    @Override
    public int ativarModuloDados() {   
        return 1;
    }
    
    
 

}
