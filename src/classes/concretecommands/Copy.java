package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;

/**
 * Copy command
 */
public class Copy implements Command{

    /**
     * Receiver to perform the action when the command is to be executed
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public Copy() {
    }

    /**
     * executes the action to be performed by the receiver
     */
    public void execute() throws NoSuchMethodException {
        // TODO implement here
        this.receiver.copy();
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
