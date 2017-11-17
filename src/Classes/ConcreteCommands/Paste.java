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
        this.position = 0;
    }

    public Paste(int position){
        this.position = position;
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

    /**
     *  @param position where to paste
     */
    public void setPaste(int position){
        this.position = position;
    }

    /**
     * @return position where we pasted
     */
    public int getPaste(){
        return this.position;
    }

    /**
     * @return position where we pasted
     */
    public boolean isNegative(){
        return this.position < 0;
    }


}