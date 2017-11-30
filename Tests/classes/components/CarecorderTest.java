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
        this.selection.setRecorder(this.recorder);
        this.selection.setReceiver(this.receiver);
        this.copy.setRecorder(this.recorder);
        this.copy.setReceiver(this.receiver);
        this.insert.setRecorder(this.recorder);
        this.insert.setReceiver(this.receiver);
        this.cut.setReceiver(this.receiver);
        this.cut.setRecorder(this.recorder);
        this.delete.setReceiver(this.receiver);
        this.delete.setRecorder(this.recorder);
        this.paste.setReceiver(this.receiver);
        this.paste.setRecorder(this.recorder);
    }

    @Test
    public void recordTest() throws Exception {
        this.recorder.record(this.insert.getClass(),this.insert.save());
        this.recorder.record(this.insert.getClass(),this.copy.save());
        this.recorder.record(this.insert.getClass(),this.selection.save());
        assertEquals("Is the object containing the mementos incremented when we are not recording",
                0, this.recorder.careclone().size());
    }

    @Test
    public void recordTest1() throws Exception {
        this.insert.execute();
        this.selection.execute();
        this.copy.execute();
        assertEquals("We check if the object containing the mementos is not incremented",
                0, this.recorder.careclone().size());
    }

    @Test
    public void recordTest2() throws Exception {
        this.startrecording.execute();
        this.insert.execute();
        this.selection.execute();
        this.copy.execute();
        this.stoprecording.execute();
        assertEquals("We check if the object containing the mementos is incremented",
                3, this.recorder.careclone().size());
    }

    @Test
    public void recordTest3() throws Exception {
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
    public void recordTest4() throws Exception {
        this.startrecording.execute();
        this.stoprecording.execute();
        this.insert.setTextinput("We don't want this to be recorded");
        this.insert.setPosition(0);
        this.insert.execute();
        assertEquals("We cannot record when recording is not on",
                true, this.recorder.careclone().isEmpty());

    }

    @Test
    public void recordTest5() throws Exception {
        this.insert.setTextinput("First lesson on testing a software ");
        this.insert.setPosition(0);
        this.startrecording.execute();
        this.insert.setTextinput("We try to do testing before coding");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput(" After we can implement methods");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.insert.execute();
        this.stoprecording.execute();
        assertEquals("Check if buffers contains insert object text",
                2, this.recorder.careclone().size());
    }

    @Test
    public void recordTest6() throws Exception {
        this.selection.setStart(10);
        this.selection.setEnd(13);
        this.insert.setTextinput("I would like to go there but I cannot");
        this.insert.setPosition(0);
        this.insert.execute();
        this.startrecording.execute();
        this.selection.execute();
        this.stoprecording.execute();
        assertEquals("We can record other commands when insert wasn't recorded before",
                1, this.recorder.careclone().size());
    }

    @Test
    public void recordTest7() throws Exception {
        this.selection.setStart(10);
        this.selection.setEnd(13);
        this.selection.setRecorder(this.recorder);
        this.insert.setTextinput("I would like to go there but I cannot");
        this.insert.setPosition(0);
        this.insert.execute();
        this.startrecording.execute();
        this.insert.execute();
        this.selection.execute();
        this.stoprecording.execute();
        assertEquals("We can record when insert was not recorded before",
                2, this.recorder.careclone().size());
    }

    @Test
    public void recordTest8() throws Exception {
        this.selection.setStart(10);
        this.selection.setEnd(13);
        this.selection.setRecorder(this.recorder);
        this.insert.setTextinput("I would like to go there but I cannot");
        this.insert.setPosition(0);
        this.insert.execute();
        this.startrecording.execute();
        this.insert.execute();
        this.insert.execute();
        this.selection.execute();
        this.stoprecording.execute();
        assertEquals("We can record insert after recording has started",
                3, this.recorder.careclone().size());
    }

    @Test
    public void recordTest9() throws Exception {
        this.selection.setStart(10);
        this.selection.setEnd(13);
        this.startrecording.execute();
        this.insert.setTextinput("What do you think about doing tests");
        this.insert.setPosition(0);
        this.insert.execute();
        this.selection.execute();
        this.stoprecording.execute();
        this.startrecording.execute();
        this.insert.setTextinput("I think it is the ideal thing to do");
        this.insert.setPosition(0);
        this.selection.setStart(9);
        this.selection.setEnd(15);
        this.insert.execute();
        this.selection.execute();
        this.stoprecording.execute();
        assertEquals("Once we have stopped recording they are no way to go back from the last recording",
                2, this.recorder.careclone().size());
    }

    @Test
    public void recordTest10() throws Exception{
        this.startrecording.setReceiver(this.recorder);
        this.stoprecording.setReceiver(this.recorder);
        this.replay.setReceiver(this.recorder);
        this.startrecording.execute();
        this.stoprecording.execute();
        this.replay.execute();
        assertEquals(true, this.recorder.careclone().isEmpty());
    }

    @Test
    public void hasAccessTest1() throws Exception{
        this.selection.setStart(10);
        this.selection.setEnd(13);
        this.insert.setTextinput("I think it is the ideal thing to do");
        this.insert.setPosition(0);
        this.startrecording.execute();
        this.insert.execute();
        this.stoprecording.execute();
        assertEquals(false, this.recorder.careclone().isEmpty());
    }

    @Test
    public void hasAccessTest2() throws Exception{
        this.selection.setStart(0);
        this.selection.setEnd(13);
        this.startrecording.execute();
        this.selection.execute();
        this.copy.execute();
        this.stoprecording.execute();
        assertEquals(false, this.recorder.careclone().isEmpty());
    }

    @Test
    public void replayTest1() throws Exception{
        this.insert.setTextinput("I think it is a good idea ");
        this.insert.setPosition(0);
        this.insert.execute();
        this.startrecording.execute();
        this.selection.setStart(0);
        this.selection.setEnd(this.receiver.getBufferClone().length());
        this.selection.execute();
        this.cut.execute();
        this.replay.execute();
        this.insert.setTextinput("But I'm not sure");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.insert.execute();
        this.stoprecording.execute();
        this.replay.execute();
        assertTrue("We cannot replay while recording and we should retrieve the last insert after replaying",
                this.receiver.getClipboardClone().getClipboard().equals("But I'm not sure" )
                && this.receiver.getBufferClone().getText().equals(this.insert.getTextinput()));
    }

    @Test
    public void replayTest2() throws Exception{
        this.insert.setTextinput("I think it is the ideal thing to do");
        this.insert.setPosition(0);
        this.startrecording.execute();
        this.insert.execute();
        this.selection.setStart(0);
        this.selection.setEnd(this.receiver.getBufferClone().length());
        this.selection.execute();
        this.cut.execute();
        this.replay.execute();
        this.insert.setTextinput(" and I allow this to happen");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.insert.execute();
        this.stoprecording.execute();
        this.replay.execute();
        assertEquals("Check if we can replay after we have stop recording",
                " and I allow this to happen and I allow this to happen", this.receiver.getBufferClone().getText());
    }

    @Test
    public void replayTest3() throws Exception{
        this.insert.setTextinput("I was there last night");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.insert.execute();
        this.startrecording.execute();
        this.selection.setStart(3);
        this.selection.setEnd(11);
        this.selection.execute();
        this.copy.execute();
        this.stoprecording.execute();
        this.insert.setTextinput("I'm wishing something right now that I was there last night");
        this.insert.setPosition(0);
        this.insert.execute();
        this.replay.execute();
        assertEquals("insert not recorder at the beginning nor at the end but selection and copy are",
                "wishing", this.receiver.getClipboardClone().getClipboard());
    }

    @Test
    public void replayTest4() throws Exception{
        this.insert.setTextinput("I think it is the ideal thing to do");
        this.insert.setPosition(0);
        this.selection.setStart(1);
        this.selection.setEnd(7);
        this.insert.execute();
        this.startrecording.execute();
        this.selection.execute();
        this.copy.execute();
        this.stoprecording.execute();
        this.selection.setStart(0);
        this.selection.setEnd(this.receiver.getBufferClone().length());
        this.selection.execute();
        this.cut.execute();
        this.insert.setTextinput("I allow this to happen");
        this.insert.setPosition(0);
        this.insert.execute();
        this.replay.execute();
        assertEquals("We want to check the state of the buffer and clipboard",
                "allow", this.receiver.getClipboardClone().getClipboard());
    }

    @Test
    public void replayTest5() throws Exception{
        this.insert.setTextinput("I think it is the ideal thing to do");
        this.insert.setPosition(0);
        this.selection.setStart(0);
        this.selection.setEnd(7);
        this.startrecording.execute();
        this.insert.execute();
        this.selection.execute();
        this.copy.execute();
        this.cut.execute();
        this.stoprecording.execute();
        this.startrecording.execute();
        this.insert.execute();
        this.selection.setStart(0);
        this.selection.setEnd(this.receiver.getBufferClone().length());
        this.selection.execute();
        this.cut.execute();
        this.insert.setTextinput("I allow this to happen");
        this.insert.setPosition(0);
        this.insert.execute();
        this.stoprecording.execute();
        this.replay.execute();
        assertEquals("In case we record insert , the buffer changes state after replay",
                "I allow this to happen", this.receiver.getBufferClone().getText());
    }
    @Test
    public void replayTest6() throws Exception{
        this.insert.setTextinput("I think it is a good idea ");
        this.insert.setPosition(0);
        this.insert.execute();
        this.startrecording.execute();
        this.selection.setStart(0);
        this.selection.setEnd(this.receiver.getBufferClone().length());
        this.selection.execute();
        this.cut.execute();
        this.stoprecording.execute();
        this.insert.setTextinput("But I'm not sure");
        this.insert.setPosition(this.receiver.getBufferClone().length());
        this.insert.execute();
        this.replay.execute();
        assertTrue("We cannot replay while recording and we should retrieve the last insert after replaying",
                this.receiver.getClipboardClone().getClipboard().equals("But I'm not sure")
                        && this.receiver.getBufferClone().getText().isEmpty());
    }
}