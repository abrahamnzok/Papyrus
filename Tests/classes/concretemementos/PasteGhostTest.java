package classes.concretemementos;

import classes.concretecommands.Paste;
import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasteGhostTest {
    private PasteGhost pasteGhost;
    private Receiver receiver;
    @Before
    public void setUp() throws Exception {
        this.receiver = receiver;
        this.pasteGhost = new PasteGhost(this.receiver,10);
    }

    @Test
    public void getPositionState() throws Exception {
        assertEquals(10, this.pasteGhost.getPositionState());
    }

}