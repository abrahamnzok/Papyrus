package classes.components;

import classes.concretecommands.Record;
import classes.concretecommands.Replay;
import classes.concretecommands.Stop;
import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoUndoEngineTest {
    private Record startrecording;
    private Carecorder recorder;
    private Stop stoprecording;
    private Replay replay;
    private BoardReceiver receiver;
    private SelectionRecordable selection;
    private CutRecordable cut;
    private DeleteRecordable delete;
    private PasteRecordable paste;
    private InsertRecordable insert;
    private CopyRecordable copy;
    private DoUndoEngine doUndoEngine;

    @Before
    public void setUp() throws Exception {
        this.receiver = new BoardReceiver();
        this.doUndoEngine = new DoUndoEngine(receiver);
        this.receiver.setRecorder(doUndoEngine);
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

    /**
     * Test to go backward without having any memento in the stack, the test should pass or throw an error
     * @throws Exception
     */
    @Test
    public void backwardTest() throws Exception {
        this.doUndoEngine.goBackward();
        this.doUndoEngine.goBackward();
        this.doUndoEngine.goBackward();
    }

    /**
     * Test to go backward multiple times
     * @throws Exception
     */
    @Test
    public void backwardTest2() throws Exception {
        this.insert.setTextinput("D");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("C");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("B");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("A");
        this.insert.setPosition(0);
        this.insert.execute();
        this.doUndoEngine.goBackward();
        this.doUndoEngine.goBackward();
        assertEquals("Backward stack should contains 2 members after going backward", 2, this.doUndoEngine.getBackwardClone().size());
        assertEquals("Forward stack should contains 2 members after going backward", 2, this.doUndoEngine.getForwardClone().size());
        assertEquals("The buffer should only contain B, C and D letters", "BCD", this.receiver.getBufferClone().getText());
    }

    /**
     * Test to go backward after going forward multiple times
     * @throws Exception
     */
    @Test
    public void backwardTest3() throws Exception {
        this.insert.setTextinput("D");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("C");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("B");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("A");
        this.insert.setPosition(0);
        this.insert.execute();
        this.doUndoEngine.goBackward();
        this.doUndoEngine.goForward();
        this.doUndoEngine.goForward();
        this.doUndoEngine.goBackward();
        assertEquals("Backward stack should contains 2 members after going backward", 3, this.doUndoEngine.getBackwardClone().size());
        assertEquals("Forward stack should contains 2 members after going backward", 1, this.doUndoEngine.getForwardClone().size());
        assertEquals("The buffer should only contain B, C and D letters", "ABCD", this.receiver.getBufferClone().getText());
    }

    /**
     * Test to go forward without having any memento in the stack, the test should pass or throw an error
     * @throws Exception
     */
    @Test
    public void forwardTest() throws Exception {
        this.doUndoEngine.goForward();
        this.doUndoEngine.goForward();
        this.doUndoEngine.goForward();
    }

    /**
     * Test to go forward after multiple backward
     * @throws Exception
     */
    @Test
    public void forwardTest2() throws Exception {
        this.insert.setTextinput("D");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("C");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("B");
        this.insert.setPosition(0);
        this.insert.execute();
        this.insert.setTextinput("A");
        this.insert.setPosition(0);
        this.insert.execute();
        this.doUndoEngine.goBackward();
        this.doUndoEngine.goBackward();
        this.doUndoEngine.goForward();
        this.doUndoEngine.goForward();
        assertEquals("Backward stack should contains 2 members after going backward", 4, this.doUndoEngine.getBackwardClone().size());
        assertEquals("Forward stack should be empty", 0, this.doUndoEngine.getForwardClone().size());
        assertEquals("The buffer should only contain B, C and D letters", "ABCD", this.receiver.getBufferClone().getText() );
    }

    /**
     * Test to record multiple actions to the stack on execution
     * @throws Exception
     */
    @Test
    public void recordTest() throws Exception {
        //Each execution should record the action in the stack
        this.insert.setPosition(0);
        this.insert.setTextinput("Hi");
        this.insert.execute();
        this.insert.setPosition(0);
        this.insert.setTextinput(" !");
        this.insert.execute();
        this.selection.setStart(0);
        this.selection.setEnd(2);
        this.selection.execute();
        this.copy.execute();
        assertEquals("Backward stack should contains 4 members", 3, this.doUndoEngine.getBackwardClone().size());
    }

}
