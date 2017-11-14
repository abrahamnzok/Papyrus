package Classes.ConcreteCommands;

import Interfaces.Command.Command;
import Interfaces.Receiver.Receiver;

import java.util.*;

/**
 * 
 */
public class Paste implements Command {

    /**
     *
     */
    private Receiver receiver;

    /**
     *
     */
    private int position;

    /**
     * Default constructor
     */
    public Paste() {
    }

    /**
     */
    public void execute() {
        // TODO implement here
        this.receiver.paste(this.position);
    }

    /**
     * @param r 
     */
    public void setReceiver(Receiver r) {
        // TODO implement here
        this.receiver = r;
    }

    public void setPaste(int position){
        this.position = position;
    }


}