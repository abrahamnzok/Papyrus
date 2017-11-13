package Classes.ConcreteCommands;

import Interfaces.Command.Command;
import Interfaces.Receiver.Receiver;

public class Selection implements Command {

    /**
     *
     */
    private Receiver receiver;

    /**
     *
     */
    private int start;

    /**
     *
     */
    private int end;

    /**
     * Default constructor
     */
    public Selection(int start, int end) {
        this.start = start;
        this.end = end;
    }


    /**
     */
    public void execute() {
        // TODO implement here
        this.receiver.select(this.start, this.end);
    }

    /**
     * @param r
     */
    public void setReceiver(Receiver r) {
        // TODO implement here
        this.receiver = r;
    }
}
