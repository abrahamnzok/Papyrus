package Classes.ConcreteCommands;

import Interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
public class InsertTest {
    private Receiver receiver;
    private Insert insert;
    @Before
    public void setUp() throws Exception {
        this.insert = Mockito.mock(Insert.class);
        this.receiver = Mockito.mock(Receiver.class);
    }

    @Test
    public void setReceiver() throws Exception {
        this.insert.setReceiver(this.receiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.insert).setReceiver(argumentCaptor.capture());
    }
}