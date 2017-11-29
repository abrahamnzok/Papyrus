package classes.recordablecommands;

import classes.components.Carecorder;
import classes.components.Pair;
import classes.concretemementos.InsertGhost;
import classes.concretemementos.SelectGhost;
import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recorder.Recorder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertRecordableTest {
    private InsertRecordable nonmockedinsert;
    private Carecorder recorder;
    private Receiver receiver;
    @Before
    public void setUp() throws Exception {
        this.nonmockedinsert = new InsertRecordable();
        this.recorder = new Carecorder();
        this.receiver = new BoardReceiver();
    }

    @Test
    public void saveInsertTest1() throws Exception {
        this.nonmockedinsert.setTextinput("Hello trying to save me?");
        this.nonmockedinsert.setPosition(10);
        InsertGhost insertGhost = (InsertGhost) this.nonmockedinsert.save();
        assertTrue(this.nonmockedinsert.getTextinput().equals(insertGhost.getTextState())
                && this.nonmockedinsert.getPosition() == insertGhost.getPositionState());
    }

    @Test
    public void saveInsertTest2() throws Exception {
        this.nonmockedinsert.setTextinput("Hello trying to save me?");
        this.nonmockedinsert.setPosition(10);
        InsertGhost insertGhost = (InsertGhost) this.nonmockedinsert.save();
        assertTrue(InsertGhost.class.isInstance(insertGhost) && Memento.class.isInstance(insertGhost));
    }

    @Test
    public void saveInsertTest3() throws Exception {
        this.nonmockedinsert.setTextinput("Hello trying to save me?");
        this.nonmockedinsert.setPosition(10);
        InsertGhost insertGhost = (InsertGhost) this.nonmockedinsert.save();
        assertTrue(InsertGhost.class.isInstance(insertGhost) && Memento.class.isInstance(insertGhost));
    }

    @Test
    public void restoreInsertTest1() throws Exception {
        this.nonmockedinsert.setTextinput("Trying to see if I get retrieved instead");
        this.nonmockedinsert.setPosition(9);
        InsertGhost insertGhost = new InsertGhost(this.nonmockedinsert.getReceiver(),"I'm here to be retrieved",10);
        this.nonmockedinsert.restore(insertGhost);
        assertTrue(this.nonmockedinsert.getTextinput().equals(insertGhost.getTextState())
                && this.nonmockedinsert.getPosition() == insertGhost.getPositionState());
    }
    @Test
    public void restoreInsertTest2() throws Exception{
        this.nonmockedinsert.setReceiver(this.receiver);
        this.nonmockedinsert.setTextinput("We try to do testing before coding");
        this.nonmockedinsert.setPosition(0);
        this.recorder.record(this.nonmockedinsert.save());
        this.nonmockedinsert.setReceiver(this.receiver);
        this.nonmockedinsert.setTextinput("Firs rule of software modeling ");
        this.nonmockedinsert.setPosition(0);
        Pair<?, ?> p = (Pair<?, ?>) this.recorder.careclone().get(0);
        Memento insertGhost =  (Memento) p.getValue();
        InsertGhost real = (InsertGhost) insertGhost;
        this.nonmockedinsert.restore(real);
        assertEquals("Check if buffers contains insert object text",
                real.getTextState(), this.nonmockedinsert.getTextinput());
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.nonmockedinsert.setPosition(14);
        SelectGhost selectGhost = new SelectGhost(this.nonmockedinsert.getReceiver(), 1,10);
        this.nonmockedinsert.restore(selectGhost);
        assertEquals("We are trying to retrieve last saved data of delete",
                this.nonmockedinsert.getPosition(), 14);
    }

}