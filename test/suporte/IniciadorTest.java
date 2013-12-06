/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suporte;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author cachutti
 */
public class IniciadorTest {
    private Comunicador comunicador;
    private Verificador verificador;
    private Iniciador iniciador;
    
    public IniciadorTest() {
    }
    
    @Before
    public void setUp() {
        comunicador = mock(Comunicador.class);
        verificador = mock(Verificador.class);
        
        iniciador = new Iniciador(comunicador, verificador);
        when(verificador.verificaStatusAlimentacaoLigado()).thenReturn(true); 
           
    }
   
    @Test
    public void testIniciarFinallizaComSucesso() {
        iniciador.iniciar();
        
        verify(comunicador).emitirComando("COMEÇAR SIMULAÇAO");
        verify(comunicador).guardarNoHistorico("PDC inicializado com sucesso.");
        assertEquals(1, iniciador.m_relPOST);    
    }
    
// o caso de teste em que ele fica aguardando não tem como testar por causa do while
    @Test
    public void testObterEstadoPDCNominal() {
        when(verificador.verificaEstado()).thenReturn("nominal");
       
        assertEquals(1, iniciador.obterEstadoPDC());
       
        verify(comunicador).emitirComando("INFORMAR ESTADO");
        verify(comunicador).guardarNoHistorico("Verificação de estado do PDC realizada com sucesso - status: nominal");
        verify(comunicador).guardarNoHistorico("PDC está no estado NOMINAL. Inicialização bem sucedida");
    }
    
    @Test
    public void testObterEstadoPDCDiferenteNominal() {
        when(verificador.verificaEstado()).thenReturn("iniciacão");
       
        assertEquals(0, iniciador.obterEstadoPDC());
       
        verify(comunicador).emitirComando("INFORMAR ESTADO");
        verify(comunicador).guardarNoHistorico("Verificação de estado do PDC realizada com sucesso - status: iniciacão");
        verify(comunicador).guardarNoHistorico("PDC NÃO está no estado NOMINAL.");
    }


    @Test
    public void testAtivarModuloDados() {
        assertEquals(1, iniciador.ativarModuloDados());
    }
}
