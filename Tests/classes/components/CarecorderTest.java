package classes.components;

import classes.concretecommands.Record;
import classes.concretecommands.Replay;
import classes.concretecommands.Stop;
import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.*;
import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarecorderTest {
    private Record startrecording;
    private Stop stoprecording;
    private Replay replay;
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
        this.delete = new DeleteRecordable();
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
    public void recordTest() throws Exception {
        this.insert.setReceiver(this.receiver);
        this.selection.setReceiver(this.receiver);
        this.copy.setReceiver(this.receiver);
        this.recorder.record(this.insert.save());
        this.recorder.record(this.copy.save());
        this.recorder.record(this.selection.save());
        assertEquals("Is the object containing the mementos incremented when we are not recording",
                0, this.recorder.careclone().size());
    }

    @Test
    public void recordTest1() throws Exception {
        this.startrecording.execute();
        this.insert.setReceiver(this.receiver);
        this.selection.setReceiver(this.receiver);
        this.copy.setReceiver(this.receiver);
        this.recorder.record(this.insert.save());
        this.recorder.record(this.copy.save());
        this.recorder.record(this.selection.save());
        this.stoprecording.execute();
        assertEquals("We check if the object containing the mementos is incremented",
                3, this.recorder.careclone().size());
    }

    @Test
    public void recordTest2() throws Exception {
        this.insert.setReceiver(this.receiver);
        this.insert.setTextinput("We try to do testing before coding");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput(" After we can implement methods");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.insert.execute();
        this.replay.execute();
        assertEquals("We cannot record without starting the recording action",
                true, this.recorder.careclone().isEmpty());
    }

    @Test
    public void recordTest3() throws Exception {
        this.startrecording.execute();
        this.stoprecording.execute();
        this.insert.setReceiver(this.receiver);
        this.insert.setTextinput("We don't want this to be recorded");
        this.insert.setPosition(0);
        this.insert.setRecorder(this.recorder);
        this.insert.execute();
        assertEquals("We cannot record when recording is not on",
                true, this.recorder.careclone().isEmpty());

    }

    @Test
    public void recordTest4() throws Exception {
        this.insert.setTextinput("First lesson on testing a software ");
        this.insert.setPosition(0);
        this.startrecording.execute();
        this.insert.setReceiver(this.receiver);
        this.insert.setTextinput("We try to do testing before coding");
        this.insert.setPosition(0);
        this.recorder.record(this.insert.save());
        this.insert.setTextinput(" After we can implement methods");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.recorder.record(this.insert.save());
        this.replay.execute();
        assertEquals("Check if buffers contains insert object text",
                "We try to do testing before coding After we can implement methods", this.receiver.getBufferClone().getText());
    }

    @Test
    public void recordTest5() throws Exception {
        this.insert.setReceiver(this.receiver);
        this.insert.setRecorder(this.recorder);
        this.selection.setReceiver(this.receiver);
        this.selection.setStart(10);
        this.selection.setEnd(13);
        this.selection.setRecorder(this.recorder);
        this.insert.setTextinput("I would like to go there but I cannot");
        this.insert.setPosition(0);
        this.insert.execute();
        this.startrecording.execute();
        this.selection.execute();
        this.stoprecording.execute();
        assertEquals("We can select what was not recorded",
                1, this.recorder.careclone().size());
    }


}