package swpdc;
import suporte.Comunicador;
import suporte.Iniciador;
import suporte.Verificador;

/**
 *
 * @author cachutti
 */
public class MainParaVerificacaoSuporte {
    static Comunicador comunicador;
    static Verificador verificador;
    static Iniciador iniciador;
   
    public static void main(String[] args){
        iniciador = new Iniciador();
        verificador = Verificador.instanciar();
        comunicador = Comunicador.instanciar();
        iniciador.iniciar();    
    }
}
