package Classes.ConcreteCommands;

import Interfaces.Command.Command;
import Interfaces.Receiver.Receiver;

public class Copy implements Command {

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
    public void execute() {
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
}
