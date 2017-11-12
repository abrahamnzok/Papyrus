package Classes.ConcreteInvoker;

import Interfaces.Command.Command;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class clientInvokerTest {
    private Command command;
    private ClientInvoker client;

    @Before
    public void setUp() throws Exception {
        this.command = Mockito.mock(Command.class);
    }

    @Test
    public void setCommandVerifyInvocation() throws Exception {
        Mockito.verify(command).execute();
    }

}