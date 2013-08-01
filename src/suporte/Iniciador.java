package suporte;

/**
 *
 * @author cachutti
 */
public class Iniciador implements IIniciador{

   /*indicam sucessos e fracassos */
   private int m_relPOST = 1;
   private int staMemPrg = 1;
   private int staMemDdo = 1; 
   Comunicador comunicador; 
   Verificador verificador;
  
    @Override
    public void iniciar() {
        verificador = Verificador.instanciar();
        comunicador = Comunicador.instanciar();
        comunicador.emitirComando("COMEÇAR SIMULAÇAO");
        
        while (!verificador.verificaStatusAlimentacaoLigado()){
            comunicador.guardarNoHistorico("Aguardando PDC ligar.");
        }
        comunicador.guardarNoHistorico("PDC inicializado com sucesso.");
    }

    @Override
    public int obterEstadoPDC() {  
        comunicador.emitirComando("INFORMAR ESTADO");
        String estado = verificador.verificaEstado();
        comunicador.guardarNoHistorico("Verificação de estado do PDC realizada com sucesso - status: " + estado );
        System.out.println(estado);
        if(estado.equals("nominal")) {
            return 1;
        }
        return 0;
    }

    @Override
    public int ativarModuloDados() {
        //iniciar gerenciamento de dados
        
        return 1;
    }
    
    
    public void gerarRelatoPOST() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
