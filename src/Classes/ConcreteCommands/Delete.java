package Classes.ConcreteCommands;

import Interfaces.Command.Command;
import Interfaces.Receiver.Receiver;

import java.util.*;

/**
 *
 */
public class Delete implements Command {


    private int position;
    /**
     *
     */
    private Receiver receiver;


    /**
     * Default constructor
     */
    public Delete(int position) {
        this.position = position;
    }

    /**
     */
    public void execute() {
        // TODO implement here
        this.receiver.delete(this.position);
    }

    /**
     * @param r
     */
    public void setReceiver(Receiver r) {
        // TODO implement here
        this.receiver = r;
    }


}
