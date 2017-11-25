package classes.concretecommands;

import interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class PasteTest {
    private Receiver receiver;
    private Paste paste;
    private Paste nonmocked;
    @Before
    public void setUp() throws Exception {
        this.receiver = Mockito.mock(Receiver.class);
        this.paste = Mockito.mock(Paste.class);
        this.nonmocked = new Paste();
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
    @Test
    public void setPosition() throws Exception {
        this.paste.setPaste(12);
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(this.paste).setPaste(argumentCaptor.capture());
    }

    @Test
    public void setNegativePosition() throws Exception {
        this.nonmocked.setPaste(-12);
        assertEquals(true, this.nonmocked.isNegative());
    }

    @Test
    public void setPaste() throws Exception {
        this.nonmocked.setPaste(12);
        assertEquals(12, this.nonmocked.getPaste());
    }

    @Test
    public void getPasteWithoutSettingIt() throws Exception {
        assertTrue(this.nonmocked.getPaste() == 0);
    }
}