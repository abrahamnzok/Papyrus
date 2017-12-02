package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;

/**
 * Cut Command
 */
public class Cut implements Command{


    /**
     * {@link Receiver}  to perform the action when the command is to be executed
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public Cut() {
    }

    /**
     * executes the action to be performed by the receiver
     * @throws NoSuchMethodException
     */
    public void execute() throws NoSuchMethodException {
        // TODO implement here
        this.receiver.cut();
    }

    /**
     * @param r receiver to perform the action when the command is to be executed
     */
    public void setReceiver(Receiver r) {
        // TODO implement here
        this.receiver = r;
    }

    /**
     * @return receiver
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}