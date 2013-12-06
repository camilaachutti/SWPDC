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
public class PacoteHKTest {
    
    public PacoteHKTest() {
    }
    
    @Test
    public void testSomeMethod() {
        String modOpe = "nominal";
        int qteErrSim  = 1;
        TipoRelatoEventoEnum relEvt = TipoRelatoEventoEnum.treBufDdoCco10;
        String tpoAmoTta = "10";
        
        PacoteHK pacoteTest = new PacoteHK(modOpe, qteErrSim, relEvt, tpoAmoTta);
        
        assertEquals("nominal", pacoteTest.modOpe);
        assertEquals(1, pacoteTest.qteErrSim);
        assertEquals(TipoRelatoEventoEnum.treBufDdoCco10, relEvt );
        assertEquals("10", pacoteTest.tpoAmoTta);
    
        
    }
    
}
