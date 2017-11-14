package Classes.ConcreteCommands;

import Interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SelectionTest {
    private Receiver receiver;
    private Selection selector;
    @Before
    public void setUp() throws Exception {
        this.selector = Mockito.mock(Selection.class);
        this.receiver = Mockito.mock(Receiver.class);
    }

    @Test
    public void execute() throws Exception {
        this.receiver.select(0, 12);
        Mockito.verify(this.receiver, Mockito.times(1)).select(0, 12);
    }

    @Test
    public void setReceiver() throws Exception {
        this.selector.setReceiver(this.receiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.selector).setReceiver(argumentCaptor.capture());
    }

}