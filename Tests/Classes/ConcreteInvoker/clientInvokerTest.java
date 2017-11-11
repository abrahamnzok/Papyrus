package Classes.ConcreteInvoker;

import Interfaces.Command.Command;
import Interfaces.Invoker.Invoker;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class clientInvokerTest {
    private Command command;
    private Invoker client;

    @Before
    public void setUp() throws Exception {
        this.command = Mockito.mock(Command.class);
        this.client = Mockito.mock(clientInvoker.class);
    }

    @Test
    public void setCommandVerifyArguments() throws Exception {
        this.client.setCommand(this.command);
        ArgumentCaptor<Command> argumentCaptor = ArgumentCaptor.forClass(Command.class);
        Mockito.verify(this.client).setCommand(argumentCaptor.capture());
    }

    @Test
    public void setCommandVerifyInvocation() throws Exception {
        this.client.setCommand(this.command);
        Mockito.verify(command, Mockito.times(1)).execute();

    }

}