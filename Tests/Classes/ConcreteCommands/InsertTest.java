package Classes.ConcreteCommands;

import Classes.Components.Buffer;
import Interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;

public class InsertTest {
    private Receiver receiver;
    private Insert insert;
    private Buffer buffer;
    @Before
    public void setUp() throws Exception {
        this.insert = Mockito.mock(Insert.class);
        this.receiver = Mockito.mock(Receiver.class);
        this.buffer = new Buffer();
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
}
