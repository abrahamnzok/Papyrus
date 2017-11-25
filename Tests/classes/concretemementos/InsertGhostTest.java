package classes.concretemementos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertGhostTest {
    private InsertGhost insertGhost;
    @Before
    public void setUp() throws Exception {
        this.insertGhost = new InsertGhost("Testing", 10);
    }

    @Test
    public void getTextState() throws Exception {
        assertEquals(10, this.insertGhost.getPositionState());
    }

    @Test
    public void getPositionState() throws Exception {
        assertEquals("Testing", this.insertGhost.getTextState());
    }

}