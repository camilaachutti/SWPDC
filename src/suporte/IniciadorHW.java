package suporte;

/**
 *
 * @author cachutti
 */
public class IniciadorHW implements IIniciadorHW{

    /**
     *
     * @return
     */

    /*indicam sucessos e fracassos */
   private int m_relPOST = 1;
   private int staMemPrg = 1;
   private int staMemDdo = 1;
   
    
    @Override
    public int iniciar() {
        //throw new UnsupportedOperationException("Not supported yet.");
        verificarHW();
        return 1; /* hw sempre estará em perfeitas condições a título de teste*/
       
    }
   
    private void verificarHW(){
       //talvez seja necessário no futuro para inicializar o simulador.
    }
}