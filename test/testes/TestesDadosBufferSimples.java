/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dados.BufferSimples;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 *
 * @author cachutti
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class TestesDadosBufferSimples extends TestCase{

    //assertEquals
    //assertTrue
    //assertFalse
    
    /* Inicializador da Classe do Teste. A anotação @beforeclass marcas um método 
     * como um método de inicialização da classe de teste. Um método de 
     * inicialização de classe de teste é executado somente uma vez, 
     * e antes de qualquer outro método na classe de teste. 
     * Por exemplo, em vez de criar uma conexão de banco de dados em um 
     * inicializador de teste e criar uma nova conexão antes de cada método 
     * de teste, você pode usar um inicializador da classe de teste para abrir 
     * uma conexão antes de executar os testes. Em seguida, é possível fechar a 
     * conexão com o finalizador da classe de teste.*/
    /*@BeforeClass
    public static void setUpClass() throws Exception {
    }*/
    /*Finalizador da Classe de Teste. A anotação @AfterClass marca um método 
     * como um método de finalizador da classe de teste. Um método finalizador 
     * da classe de teste é executado apenas uma vez e depois que todos os 
     * outros métodos na classe de teste foram finalizados.*/
    /*@AfterClass
    public static void tearDownClass() throws Exception {
    }*/
    /*Inicializador de Teste. A anotação @Before marca um método como um método 
     * de inicialização de teste. Um método de inicialização de teste é 
     * executado antes de cada caso de teste na classe de teste. 
     * Um método de inicialização de teste não é obrigatório para executar os 
     * testes, mas se você precisar inicializar algumas variáveis antes de 
     * executar um teste, você usará um método inicializador de teste.*/
    @Before
    public void setUp() throws Exception {
        
        
        
        
    }

    /*Finalizador de Teste. A anotação @After marca um método como um método de 
     * finalizador de teste. Um método finalizador de teste é executado depois 
     * de cada caso de teste na classe de teste. Um método finalizador de teste 
     * não é obrigatório para executar testes, mas você pode precisar de um 
     * finalizador para limpar eventuais dados que foram necessários ao executar
     * os casos de teste.*/
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void checkAlocacaoBufferSimples() {
        BufferSimples bufferTest;
            bufferTest = new BufferSimples(this, (byte)5);

            //coloca algo e só aí testar para fazer sentido.
    //    assertTrue(BufferSimples.alocar(Object area, byte tamanho), "Alocação no Buffer de tamanho" + tamanho + "registrada"));

    }


    @Test
    public void checkEstaVazio() {
        BufferSimples bufferTest;
            bufferTest = new BufferSimples(this, (byte)5);
           int expResult = 1; 
           int  result = bufferTest.estaVazio();
            assertEquals( expResult, result);
        
}}