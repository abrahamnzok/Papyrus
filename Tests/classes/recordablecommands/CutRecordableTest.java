package classes.recordablecommands;

import classes.concretemementos.CutGhost;
import classes.concretemementos.SelectGhost;
import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CutRecordableTest {
    private CutRecordable cut;
    @Before
    public void setUp() throws Exception {
        this.cut = new CutRecordable();
    }

    @Test
    public void receiverStateIsNotNull() throws Exception {
        this.cut.setReceiver(new BoardReceiver());
        CutGhost cutGhost = new CutGhost(this.cut.getReceiver());
        this.cut.restore(cutGhost);
        assertTrue(this.cut.getReceiver() != null
                && Receiver.class.isInstance(this.cut.getReceiver()));
    }

}