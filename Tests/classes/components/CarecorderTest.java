package classes.components;

import classes.concretecommands.Record;
import classes.concretecommands.Replay;
import classes.concretecommands.Stop;
import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.*;
import interfaces.Receiver.Receiver;
import interfaces.command.Command;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarecorderTest {
    private Record startrecording;
    private Stop stoprecording;
    private Replay replay;
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
        this.startrecording = new Record();
        this.stoprecording = new Stop();
        this.replay = new Replay();
        this.startrecording.setReceiver(this.recorder);
        this.stoprecording.setReceiver(this.recorder);
        this.replay.setReceiver(this.recorder);
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
        this.insert.execute();
        this.insert.setTextinput(" After we can implement methods");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.insert.execute();
        this.replay.execute();
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