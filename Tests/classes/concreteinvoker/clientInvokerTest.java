package classes.concreteinvoker;

import interfaces.command.Command;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class clientInvokerTest {
    private Command command;
    private ClientInvoker client;

    @Before
    public void setUp() throws Exception {
        this.command = Mockito.mock(Command.class);
        this.client = new ClientInvoker();
    }

    @Test
    public void setCommandVerifyInvocation() throws Exception {
        this.client.setCommand(command);
        Mockito.verify(this.command).execute();
    }

}