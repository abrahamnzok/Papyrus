package classes.components;

import classes.concretecommands.*;

import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarecorderTest {
    private Receiver receiver;
    private Selection selection;
    private Cut cut;
    private Delete delete;
    private Paste paste;
    private Insert insert;
    private Copy copy;
    private Carecorder recorder;
    @Before
    public void setUp() throws Exception {
        this.receiver = new BoardReceiver();
        this.selection = new Selection();
        this.cut = new Cut();
        this.delete = new Delete(10);
        this.insert = new Insert();
        this.paste = new Paste();
        this.copy = new Copy();
        this.recorder = new Carecorder();
    }

    @Test
    public void recordCommands() throws Exception {

    }

    @Test
    public void recordSeveralCommandsTest1() throws Exception {

    }

    @Test
    public void recordSeveralCommandsTest2() throws Exception {

    }



}