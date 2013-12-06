/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package suporte;

import java.io.BufferedReader;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author cachutti
 */
public class VerificadorTest {
    private BufferedReader bufReaderRegistroTemp;
    private BufferedReader bufReaderSysInfo;
    private Comunicador comunicador;
    private Verificador verificador;
    
    @Before
    public void setUp() {
        bufReaderRegistroTemp = mock(BufferedReader.class);
        bufReaderSysInfo = mock(BufferedReader.class);
        comunicador = mock(Comunicador.class);
        
        verificador = new Verificador(bufReaderRegistroTemp, bufReaderSysInfo, comunicador);
    }

    @Test
    public void testVerificaStatusAlimentacaoLigadoSucesso() throws IOException {
        when(bufReaderSysInfo.readLine()).thenReturn("[status] ligado");
        
        assertTrue(verificador.verificaStatusAlimentacaoLigado());
    }

    @Test
    public void testVerificaStatusAlimentacaoDiferenteDeLigado() throws IOException {
         when(bufReaderSysInfo.readLine()).thenReturn("[status] desligado");
         
         assertFalse(verificador.verificaStatusAlimentacaoLigado());
    }
    
    @Test
    public void testVerificaStatusAlimentacaoDiferenteExcecao() throws IOException {
        when(bufReaderSysInfo.readLine()).thenThrow(new IOException());
        
        assertFalse(verificador.verificaStatusAlimentacaoLigado());
    }
    
    @Test
    public void testVerificaEstadoQuandoLeModoOp() throws IOException {        
        when(bufReaderSysInfo.readLine()).thenReturn("[modoOp] nominal");
        
        assertEquals("nominal", verificador.verificaEstado());
    }

    @Test
    public void testVerificaEstadoQuandoLeNull() throws IOException {
        when(bufReaderSysInfo.readLine()).thenReturn(null);
        
        assertEquals(null, verificador.verificaEstado());
        verify(comunicador).guardarNoHistorico("Problema com o o arquivo de sistema do PDC");
    }
    
    @Test
    public void testVerificaEstadoQuandoNaoLeModoOp() throws IOException {
        when(bufReaderSysInfo.readLine()).thenReturn("[status] ligado");
        
        assertEquals(null, verificador.verificaEstado());
        verify(comunicador).guardarNoHistorico("Problema com o o arquivo de sistema do PDC");
    }

    @Test
    public void testVerificaEstadoExcecao() throws IOException {
        when(bufReaderSysInfo.readLine()).thenThrow(new IOException());
        
        assertEquals(null, verificador.verificaEstado());
        verify(comunicador).guardarNoHistorico("Problema com o o arquivo de sistema do PDC");
    }
    
    @Test
    public void testObterAmostraNull() throws IOException {
        when(bufReaderRegistroTemp.readLine()).thenReturn(null);
        
        assertEquals(null, verificador.obterAmostras(2));
        verify(comunicador).guardarNoHistorico("Problema no arquivo de amostras");
    }
    
    @Test
    public void testObterAmostraNaoAtual() throws IOException {
        when(bufReaderRegistroTemp.readLine()).thenReturn("[numAm] 3");
        
        assertEquals(null, verificador.obterAmostras(2));
        verify(comunicador).guardarNoHistorico("Arquivo de amostras desatualizado");
    }
    
    @Test
    public void testObterAmostraNaoNumAm() throws IOException {
        when(bufReaderRegistroTemp.readLine()).thenReturn("[amostras] 7");
        
        assertEquals(null, verificador.obterAmostras(2));
        verify(comunicador).guardarNoHistorico("Problema no arquivo de amostras");
    }
    
    @Test
    public void testObterAmostraSucesso() throws IOException {
        when(bufReaderRegistroTemp.readLine()).thenReturn("[numAm] 1 [dados] 18.8, -31.5, 29.8, 24.8, -13.8, 25.6, 13.7, -19.3, 17.8, 24.1, -17.4, 36.4 ");

        float[] amostrasEsperadas = {18.8f, -31.5f, 29.8f, 24.8f, -13.8f, 25.6f, 13.7f, -19.3f, 17.8f, 24.1f, -17.4f, 36.4f};
        float[] amostras = verificador.obterAmostras(1);
        for (int i = 0; i < 12; i++) {
            assertEquals(amostrasEsperadas[i], amostras[i], 0.00001f);
        }
        verify(comunicador).guardarNoHistorico("Amostras obtidas com sucesso");       
    }
  
    @Test
    public void testObterAmostraExcecao() throws IOException {
        when(bufReaderRegistroTemp.readLine()).thenThrow(new IOException());
        
        assertEquals(null, verificador.obterAmostras(2));
        verify(comunicador).guardarNoHistorico("Problema no arquivo de amostras");
    }
}
