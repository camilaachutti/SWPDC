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
public class RelatoEventoTest {
    private RelatoEvento result;
    
    public RelatoEventoTest() {
        
    }
    
    @Before
    public void setUp() {
        int[] info = {1, 2};
        result = new RelatoEvento(TipoRelatoEventoEnum.treBufDdoCco10, info, 10);   
    }
   
    @Test
    public void testGetIdTipo() {
        
        TipoRelatoEventoEnum Obresult = result.getIdTipo();
        TipoRelatoEventoEnum expResult = TipoRelatoEventoEnum.treBufDdoCco10;
        assertEquals(expResult, Obresult);
       
    }

    @Test
    public void testSetIdTipo() {
        result.setIdTipo(TipoRelatoEventoEnum.treBufDdoCco90);
        assertEquals(TipoRelatoEventoEnum.treBufDdoCco90, result.idTipo);
    }

    @Test
    public void testGetInfo() {
        int[] expResult = {1, 2};
        int[] Obresult = result.getInfo();
        assertArrayEquals(expResult, Obresult);
    }

    @Test
    public void testSetInfo() {
        int[] info = {3};
        result.setInfo(info);
        assertEquals(info, result.info);
    }

    @Test
    public void testGetTimestamp() {
        int expResult = 10;
        int Obresult = result.getTimestamp();
        assertEquals(expResult, Obresult);
    }

    @Test
    public void testSetTimestamp() {
        int timestamp = 3;
        result.setTimestamp(timestamp);
        assertEquals(timestamp, result.timestamp);
    }

    
}
