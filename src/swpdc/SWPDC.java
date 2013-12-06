package swpdc; 

import dados.GerenciadorDados;
import dados.Housekeeper;
import dados.Temperatura;
import java.io.IOException;
import suporte.Iniciador;

/**
 *
 * @author cachutti
 */
public class SWPDC {

	private GerenciadorDados gerenciadorDados;
	private static int estadoPDC;
	Iniciador iniciador;
	Housekeeper hk;
	static Temperatura temperatura;

	public SWPDC(Housekeeper hk, GerenciadorDados gd) {
		this.hk = hk;
		gerenciadorDados = gd;
	}

	public static void main(String[] args) {
		Iniciador iniciador = new Iniciador();

		iniciador.iniciar();
		if (iniciador.m_relPOST == 1){
			estadoPDC = iniciador.obterEstadoPDC();
		}

		if (estadoPDC == 1){
			iniciador.ativarModuloDados();
		}

		temperatura = new Temperatura();
		temperatura.executar(10);

	}

	/**
	 * Iniciação das tarefas de regime permanente (classes ativas).
	 */
	public void iniciarTarefas(){ 

		gerenciadorDados = GerenciadorDados.instanciar();
		gerenciadorDados.iniciar();
	}

        public void finalizarTarefas(){
            iniciador.finalizar();               
	}


}
