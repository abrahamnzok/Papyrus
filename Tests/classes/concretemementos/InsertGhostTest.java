package classes.concretemementos;

import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertGhostTest {
    private InsertGhost insertGhost;
    private Receiver receiver;
    @Before
    public void setUp() throws Exception {
        this.receiver = new BoardReceiver();
        this.insertGhost = new InsertGhost(this.receiver, "Testing", 10);
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