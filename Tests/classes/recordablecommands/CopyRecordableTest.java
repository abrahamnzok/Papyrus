package classes.recordablecommands;

import classes.concretemementos.CopyGhost;
import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CopyRecordableTest {
    private CopyRecordable copy;

    @Before
    public void setUp() throws Exception {
        this.copy = new CopyRecordable();
    }

    @Test
    public void receiverStateIsNotNull() throws Exception {
        this.copy.setReceiver(new BoardReceiver());
        CopyGhost copyGhost = new CopyGhost(this.copy.getReceiver());
        this.copy.restore(copyGhost);
        assertTrue(this.copy.getReceiver() != null
                && Receiver.class.isInstance(this.copy.getReceiver()));
    }



}