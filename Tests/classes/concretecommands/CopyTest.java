package classes.concretecommands;

import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class CopyTest {

    private Receiver receiver;
    private Copy copy;
    @Before
    public void setUp() throws Exception {
        this.copy = Mockito.mock(Copy.class);
        this.receiver = Mockito.mock(Receiver.class);
    }

    @Test
    public void execute() throws Exception {
        this.receiver.copy();
        Mockito.verify(this.receiver, Mockito.times(1)).copy();
    }

    @Test
    public void setReceiver() throws Exception {
        this.copy.setReceiver(this.receiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.copy).setReceiver(argumentCaptor.capture());
    }

}