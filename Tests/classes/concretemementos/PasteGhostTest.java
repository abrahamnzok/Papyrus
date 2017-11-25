package classes.concretemementos;

import classes.concretecommands.Paste;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasteGhostTest {
    private PasteGhost pasteGhost;
    @Before
    public void setUp() throws Exception {
        this.pasteGhost = new PasteGhost(10);
    }

    @Test
    public void getPositionState() throws Exception {
        assertEquals(10, this.pasteGhost.getPositionState());
    }

}