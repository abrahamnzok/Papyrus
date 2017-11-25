package classes.concretecommands;

import classes.concretemementos.DeleteGhost;
import classes.concretemementos.InsertGhost;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DeleteTest {
    private Receiver receiver;
    private Delete delete;
    private Delete nonmockedelete;
    @Before
    public void setUp() throws Exception {
        this.delete = Mockito.mock(Delete.class);
        this.receiver = Mockito.mock(Receiver.class);
        this.nonmockedelete = new Delete();
    }

    @Test
    public void execute() throws Exception {
        this.receiver.delete(0);
        Mockito.verify(this.receiver, Mockito.times(1)).delete(0);
    }

    @Test
    public void setReceiver() throws Exception {
        this.delete.setReceiver(this.receiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.delete).setReceiver(argumentCaptor.capture());
    }

    @Test
    public void saveDeleteTest1() throws Exception {
        this.nonmockedelete.setPosition(10);
        DeleteGhost pasteGhost = (DeleteGhost) this.nonmockedelete.save();
        assertEquals(this.nonmockedelete.getPosition(), pasteGhost.getPositionState());
    }

    @Test
    public void saveDeleteTest2() throws Exception {
        this.nonmockedelete.setPosition(10);
        DeleteGhost pasteGhost = (DeleteGhost) this.nonmockedelete.save();
        assertEquals(this.nonmockedelete.getPosition(), pasteGhost.getPositionState());
    }

    @Test
    public void saveDeleteTest3() throws Exception {
        this.nonmockedelete.setPosition(10);
        assertTrue(DeleteGhost.class.isInstance(this.nonmockedelete.save())
                && Memento.class.isInstance(this.nonmockedelete.save()));
    }
    @Test
    public void restoreDeleteTest1() throws Exception {
        this.nonmockedelete.setPosition(14);
        DeleteGhost pasteGhost = new DeleteGhost(10);
        this.nonmockedelete.restore(pasteGhost);
        assertEquals("We are trying to retrieve last saved data of delete",
                10, this.nonmockedelete.getPosition());
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.nonmockedelete.setPosition(14);
        InsertGhost insertGhost = new InsertGhost("Cant do this!",10);
        this.nonmockedelete.restore(insertGhost);
        assertEquals("We are trying to retrieve last saved data of delete",
                this.nonmockedelete.getPosition(), 14);
    }

}