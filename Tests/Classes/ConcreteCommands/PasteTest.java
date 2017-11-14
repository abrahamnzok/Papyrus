package Classes.ConcreteCommands;

import Classes.Components.Buffer;
import Interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PasteTest {
    private Receiver receiver;
    private Buffer buffer;
    private Paste paste;
    @Before
    public void setUp() throws Exception {
        this.buffer = Mockito.mock(Buffer.class);
        this.receiver = Mockito.mock(Receiver.class);
        this.paste = Mockito.mock(Paste.class);
    }

    @Test
    public void execute() throws Exception {
        this.receiver.paste(12);
        Mockito.verify(this.receiver, Mockito.times(1)).paste(12);
    }

    @Test
    public void setReceiver() throws Exception {
        this.paste.setReceiver(this.receiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.paste).setReceiver(argumentCaptor.capture());
    }
}