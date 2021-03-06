package classes.concretecommands;

import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class SelectionTest {
    private Receiver mockreceiver;
    private Selection mockselector;
    private Selection selection;

    @Before
    public void setUp() throws Exception {
        this.mockselector = Mockito.mock(Selection.class);
        this.mockreceiver = Mockito.mock(Receiver.class);
        this.selection = new Selection(10, 12);
    }

    @Test
    public void execute() throws Exception {
        this.mockreceiver.select(0, 12);
        Mockito.verify(this.mockreceiver, Mockito.times(1)).select(0, 12);
    }

    @Test
    public void setReceiver() throws Exception {
        this.mockselector.setReceiver(this.mockreceiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.mockselector).setReceiver(argumentCaptor.capture());
    }
    @Test
    public void getStart() throws Exception {
        assertEquals(10, this.selection.getStart());
    }

    @Test
    public void getEnd() throws Exception {
        assertEquals(12, this.selection.getEnd());
    }

}