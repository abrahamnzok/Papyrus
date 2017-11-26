package classes.concretemementos;

import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectGhostTest {
    private SelectGhost selectGhost;
    private Receiver receiver;
    @Before
    public void setUp() throws Exception {
        this.receiver = new BoardReceiver();
        this.selectGhost = new SelectGhost(this.receiver,10, 12);
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