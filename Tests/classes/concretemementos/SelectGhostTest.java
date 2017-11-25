package classes.concretemementos;

import classes.concretecommands.Selection;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectGhostTest {
    private SelectGhost selectGhost;
    @Before
    public void setUp() throws Exception {
        this.selectGhost = new SelectGhost(10, 12);
    }

    @Test
    public void getStartState() throws Exception {
        assertEquals( 10, this.selectGhost.getStartState());
    }

    @Test
    public void getEndState() throws Exception {
        assertEquals(12, this.selectGhost.getEndState());
    }
}