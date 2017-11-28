package classes.concretecommands;

import classes.concretemementos.DeleteGhost;
import classes.concretemementos.InsertGhost;
import classes.concretereceiver.BoardReceiver;
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
    private Receiver receiver1;

    @Before
    public void setUp() throws Exception {
        this.delete = Mockito.mock(Delete.class);
        this.receiver = Mockito.mock(Receiver.class);
        this.nonmockedelete = new Delete();
        this.receiver1 = new BoardReceiver();
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


}