/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suporte;

import java.io.BufferedWriter;
import java.io.IOException;
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
public class ComunicadorTest {
    
    BufferedWriter instrucao;
    BufferedWriter historico;
    Comunicador comunicador;
    
    public ComunicadorTest() {
    }
    
    @Before
    public void setUp() {
        instrucao = mock(BufferedWriter.class);
        historico = mock(BufferedWriter.class);
        
        comunicador = spy(new Comunicador(instrucao, historico));
        when(comunicador.getDataTime()).thenReturn("dd/MM/yyyy HH:mm:ss.SSS");
        
    }
    
    @Test
    public void testEmissaoDeComandoBemSucedida() throws IOException {
          
        String comando = "example command";
        comunicador.emitirComando(comando);
        
        verify(instrucao).append(comando);
        verify(instrucao).newLine();
        verify(instrucao).flush();
        
        String expectedToWriteOnHistorico = 
                comunicador.getDataTime() + " " +
                comunicador.getDataTime() + " emitiu comando: " + comando;
        verify(historico).append(expectedToWriteOnHistorico);
        verify(historico).newLine();
        verify(historico).flush();
    }
    
    @Test
    public void testEmissaoDeComandoMalSucedida() throws IOException {
        String comando = "example command";
        comunicador.emitirComando(comando); 
    }
    
    @Test
    public void testGuardarHistoricoBemSucedida() throws IOException {
        
        String evento = "relato evento";
        comunicador.guardarNoHistorico(evento);
    
        String expectedToWriteOnHistorico = comunicador.getDataTime() + " " + evento;
        verify(historico).append(expectedToWriteOnHistorico);
        verify(historico).newLine();
        verify(historico).flush();
    
    }
    
    @Test
    public void testGuardaHistoricoMalSucedida() throws IOException {
        String evento = "evento";
        comunicador.guardarNoHistorico(evento);
        comunicador.emitirComando(evento);
    }
    
    @Test
    public void testInstanciar() {
        Comunicador result = Comunicador.instanciar();
        assertTrue(result != null);
    }
}
