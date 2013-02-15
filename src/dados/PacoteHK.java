/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author cachutti
 */

//Representação de um pacote de dados de Housekeeping.
public class PacoteHK {
    
    public int amoTta; //Últimas 120 amostras de temperaturas, 60 amostras
                        //por cada ponto (1 e 2), intercalados (10 bits por amostra).
    public int modOpe; //Modo de operação corrente do SWPDC.
    public double ptrCga; //Ponteiro de carga de programas.
    public int qteErrCG; //Quantidade de erros de cão-de-guarda ocorridos desde o último zeramento.
    public int qteErrDup; //Quantidade de erros duplos ocorridos desde o último zeramento.
    public int qteErrSim; //Quantidade de erros simples ocorridos desde o último zeramento.
    public int relEvt; //Últimos relatos de eventos ocorridos.
    public int staAlmEHX1; //Status da alimentação do conjunto EPP-HX1.
    public int staAlmEHX2; //Status da alimentação do conjunto EPP-HX2.
    public double tamanho; //Tamanho dos dados de housekeeping.
    public long tempoATual; //Tempo em que é formado o pacote (que será estampado no pacote de housekeeping)
    public double tpoAmoTta; //Tempo de amostragem de temperaturas.
    public double tpoHke; //Tempo de housekeeping em segundos.
    
}
