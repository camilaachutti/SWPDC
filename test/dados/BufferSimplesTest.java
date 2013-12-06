/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author cachutti
 */
public class BufferSimplesTest {
    
    public BufferSimplesTest() {
    }
    
    @Test
    public void testAlocarVazio() {
        System.out.println("alocarVazio");
        Object area = null;
        byte tamanho = 0;
        BufferSimples instance = new BufferSimples(area, tamanho);
        instance.alocar(area, tamanho);
        }

    @Test
    public void testAlocar() {
        System.out.println("alocar");
        Object area = null;
        byte tamanho = (byte)100;
        BufferSimples instance = new BufferSimples(area, tamanho);
        instance.alocar(area, tamanho);
        }
    
    @Test
    public void testEstaVazio() {
        System.out.println("estaVazio");
        Object area = null;
        byte tamanho = 0;
        BufferSimples instance = new BufferSimples(area, tamanho);
        boolean expResult = true;
        boolean result = instance.estaVazio(); 
        assertEquals(expResult, result);
        }

    @Test
    public void testInserir() {
        int index = 0;
        float dado = (float) 12.4;
        byte tamanho = (byte)100;
        Object area = null;
        BufferSimples instance = new BufferSimples(area, tamanho);
        boolean result = instance.inserir(dado, (byte)4, index);
        assertTrue(result);
      }

    
    @Test
    public void testTamanho() {
        System.out.println("tamanho");
        byte tamanho = (byte) 100;
        BufferSimples instance = new BufferSimples(null, tamanho);
        byte result = instance.tamanho();
        assertEquals(tamanho, result);
      
    }
    
    @Test
    public void testRecuperar() {
        System.out.println("recuperar");
        int index = 0;
        float dado = (float) 19.4;
        float dadoRecuperado;
        byte tamanho = 100;
        BufferSimples instance = new BufferSimples(null, tamanho);
        instance.inserir(dado, tamanho, index);
        dadoRecuperado = instance.recuperar(0);
        assertTrue(dadoRecuperado - dado == 0);
     }
    
    
    @Test
    public void testRemover() {
        System.out.println("remover");
        int index = 0;
        float dado = (float)18.5;
        byte tamanho = 100;
        BufferSimples instance = new BufferSimples(null, tamanho);
        BufferSimples expected = new BufferSimples(null, tamanho);
        instance.inserir(dado, tamanho, index);
        instance.remover(100);
        assertTrue(instance.posicao() == expected.posicao());
    }
}

