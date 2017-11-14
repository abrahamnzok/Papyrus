package Classes.ConcreteCommands;

import Interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CutTest {
    private Receiver receiver;
    private Cut cut;
    @Before
    public void setUp() throws Exception {
        this.cut = Mockito.mock(Cut.class);
        this.receiver = Mockito.mock(Receiver.class);
    }

    @Test
    public void execute() throws Exception {
        this.receiver.cut();
        Mockito.verify(this.receiver, Mockito.times(1)).cut();
    }

    @Test
    public void setReceiver() throws Exception {
        this.cut.setReceiver(this.receiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.cut).setReceiver(argumentCaptor.capture());
    }
}