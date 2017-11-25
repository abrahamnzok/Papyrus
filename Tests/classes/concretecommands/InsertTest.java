package classes.concretecommands;

import classes.components.Buffer;
import classes.concretemementos.InsertGhost;
import classes.concretemementos.SelectGhost;
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
    @Before
    public void setUp() throws Exception {
        this.insert = Mockito.mock(Insert.class);
        this.receiver = Mockito.mock(Receiver.class);
        this.nonmockedinsert = new Insert();
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
        this.insert.setTextToInsert(insert);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(this.insert).setTextToInsert(argumentCaptor.capture());
    }

    @Test
    public void setTextToInsert() throws Exception {
        Insert insertObj = new Insert();
        String insert = "Insert this text";
        insertObj.setTextToInsert(insert);
        assertEquals(insert, insertObj.getTextToInsert());
    }

    @Test
    public void saveInsertTest1() throws Exception {
        this.nonmockedinsert.setTextToInsert("Hello trying to save me?");
        this.nonmockedinsert.setPosition(10);
        InsertGhost insertGhost = (InsertGhost) this.nonmockedinsert.save();
        assertTrue(this.nonmockedinsert.getTextToInsert().equals(insertGhost.getTextState())
                && this.nonmockedinsert.getPosition() == insertGhost.getPositionState());
    }

    @Test
    public void saveInsertTest2() throws Exception {
        this.nonmockedinsert.setTextToInsert("Hello trying to save me?");
        this.nonmockedinsert.setPosition(10);
        InsertGhost insertGhost = (InsertGhost) this.nonmockedinsert.save();
        assertTrue(InsertGhost.class.isInstance(insertGhost) && Memento.class.isInstance(insertGhost));
    }

    @Test
    public void saveInsertTest3() throws Exception {
        this.nonmockedinsert.setTextToInsert("Hello trying to save me?");
        this.nonmockedinsert.setPosition(10);
        InsertGhost insertGhost = (InsertGhost) this.nonmockedinsert.save();
        assertTrue(InsertGhost.class.isInstance(insertGhost) && Memento.class.isInstance(insertGhost));
    }

    @Test
    public void restoreInsertTest1() throws Exception {
        this.nonmockedinsert.setTextToInsert("Trying to see if I get retrieved instead");
        this.nonmockedinsert.setPosition(9);
        InsertGhost insertGhost = new InsertGhost("I'm here to be retrieved",10);
        this.nonmockedinsert.restore(insertGhost);
        assertTrue(this.nonmockedinsert.getTextToInsert().equals(insertGhost.getTextState())
                && this.nonmockedinsert.getPosition() == insertGhost.getPositionState());
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.insert.setPosition(14);
        SelectGhost selectGhost = new SelectGhost(1,10);
        this.insert.restore(selectGhost);
        assertEquals("We are trying to retrieve last saved data of delete",
                this.insert.getPosition(), 14);
    }
}
