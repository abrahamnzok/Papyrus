package classes.concretecommands;

import classes.concretemementos.InsertGhost;
import classes.concretemementos.SelectGhost;
import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class InsertTest {
    private Receiver receiver;
    private Insert insert;
    private Insert nonmockedinsert;
    private Receiver receiver1;

    @Before
    public void setUp() throws Exception {
        this.insert = Mockito.mock(Insert.class);
        this.receiver = Mockito.mock(Receiver.class);
        this.nonmockedinsert = new Insert();
        this.receiver1 = new BoardReceiver();
    }

    @Test
    public void execute() throws Exception {
        this.receiver.insert("Checking if insert in called", 12);
        Mockito.verify(this.receiver, Mockito.times(1)).insert("Checking if insert in called", 12);
    }

    @Test
    public void setReceiver() throws Exception {
        this.insert.setReceiver(this.receiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.insert).setReceiver(argumentCaptor.capture());
    }

    @Test
    public void getTextToInsert() throws Exception {
        String insert = "Insert this text";
        this.insert.setTextinput(insert);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(this.insert).setTextinput(argumentCaptor.capture());
    }

    @Test
    public void setTextToInsert() throws Exception {
        Insert insertObj = new Insert();
        String insert = "Insert this text";
        insertObj.setTextinput(insert);
        assertEquals(insert, insertObj.getTextinput());
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
        InsertGhost insertGhost = new InsertGhost(this.receiver1,"I'm here to be retrieved",10);
        this.nonmockedinsert.restore(insertGhost);
        assertTrue(this.nonmockedinsert.getTextinput().equals(insertGhost.getTextState())
                && this.nonmockedinsert.getPosition() == insertGhost.getPositionState());
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.nonmockedinsert.setPosition(14);
        SelectGhost selectGhost = new SelectGhost(this.receiver1, 1,10);
        this.nonmockedinsert.restore(selectGhost);
        assertEquals("We are trying to retrieve last saved data of delete",
                this.nonmockedinsert.getPosition(), 14);
    }
}
