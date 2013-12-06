/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cachutti
 */
public class GerenciadorDadosTest {
    
    public GerenciadorDadosTest() {
    }
    
    @Test
    public void testInstanciar() {
        GerenciadorDados result = GerenciadorDados.instanciar();
        assertTrue(result != null);
    }

    @Test
    public void testAdicionarDiferenteEvento() {
        TipoBufferEnum local = TipoBufferEnum.tbCientifico;
        int dado = 0;
        byte tamanho = 0;
        GerenciadorDados instance = GerenciadorDados.instanciar();
        boolean expResult = false;
        boolean result = instance.adicionar(local, dado, tamanho);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoverDiferenteEvento() {
        TipoBufferEnum local = TipoBufferEnum.tbCientifico;
        int dado = 0;
        byte tamanho = 0;
        GerenciadorDados instance = GerenciadorDados.instanciar();
        double expResult = 0.0;
        double result = instance.remover(local, dado, tamanho);
        assertEquals(expResult, result, 0.0);
    }

   
}
