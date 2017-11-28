package classes.components;

import classes.concretecommands.*;

import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.*;
import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarecorderTest {
    private Buffer buffer;
    private ClipBoard clipBoard;
    private Ranger ranger;
    private Receiver receiver;
    private SelectionRecordable selection;
    private CutRecordable cut;
    private DeleteRecordable delete;
    private PasteRecordable paste;
    private InsertRecordable insert;
    private CopyRecordable copy;
    private Carecorder recorder;
    @Before
    public void setUp() throws Exception {
        this.receiver = new BoardReceiver();
        this.selection = new SelectionRecordable();
        this.cut = new CutRecordable();
        this.delete = new DeleteRecordable(10);
        this.insert = new InsertRecordable();
        this.paste = new PasteRecordable();
        this.copy = new CopyRecordable();
        this.recorder = new Carecorder();
    }

    @Test
    public void recordTest1() throws Exception {
        this.insert.setReceiver(this.receiver);
        this.selection.setReceiver(this.receiver);
        this.delete.setReceiver(this.receiver);
        this.insert.setTextinput("We try to do testing before coding");
        this.insert.setPosition(0);
        this.selection.setStart(10);
        this.selection.setEnd(15);
        this.delete.setPosition(10);
        this.recorder.record(this.insert.save());
        this.recorder.record(this.delete.save());
        this.recorder.record(this.selection.save());
        assertTrue(!this.recorder.careclone().isEmpty());
    }

    @Test
    public void recordTest2() throws Exception {
        this.insert.setReceiver(this.receiver);
        this.insert.setTextinput("We try to do testing before coding");
        this.insert.setPosition(0);
        this.recorder.record(this.insert.save());
        this.receiver.insert(this.insert.getTextinput(), this.insert.getPosition());
        this.recorder.stop();
        this.insert.setTextinput(" After we can implement methods");
        this.insert.setPosition(this.receiver.getBufferClone().length() );
        this.receiver.insert(this.insert.getTextinput(), this.insert.getPosition());
        this.recorder.replay();
        assertEquals("Check if buffers contains insert object text",
                "We try to do testing before coding", this.receiver.getBufferClone().getText());
    }

    @Test
    public void recordTest3() throws Exception {

    }

    @Test
    public void recordTest4() throws Exception {

    }

    @Test
    public void recordTest5() throws Exception {

    }

    @Test
    public void recordSeveralCommandsTest2() throws Exception {

    }



}