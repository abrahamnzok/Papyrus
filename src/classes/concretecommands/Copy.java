package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;

public class Copy implements Command{

    /**
     *
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public Copy() {
    }

    /**
     */
    public void execute() throws NoSuchMethodException {
        // TODO implement here
        this.receiver.copy();
    }

    /**
     * @param r
     */
    public void setReceiver(Receiver r) {
        // TODO implement here
        this.receiver = r;
    }

    /**
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}
