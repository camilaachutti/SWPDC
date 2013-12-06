package dados;

import java.lang.reflect.Array;

/**
 *
 * @author cachutti
 */

//Representação de um pacote de dados de Housekeeping.

//Nesse primeiro momento somente estão implementadas e fazem sentido as 
//informações relativas a temperatura.
public class PacoteHK {

    public float[] amoTta = new float[12]; //Últimas 12 amostras de temperatura
    public String modOpe; //Modo de operação corrente do SWPDC.
    public int qteErrSim; //Quantidade de erros simples ocorridos desde o último zeramento.
    public TipoRelatoEventoEnum relEvt; //Últimos relatos de eventos ocorridos.
    public String tpoAmoTta; //Tempo de amostragem de temperaturas.

    public PacoteHK(String modOpe, int qteErrSim, TipoRelatoEventoEnum relEvt, String tpoAmoTta) {
        this.modOpe = modOpe;
        this.qteErrSim = qteErrSim;
        this.relEvt = relEvt;
        this.tpoAmoTta = tpoAmoTta;
    }

 

}
