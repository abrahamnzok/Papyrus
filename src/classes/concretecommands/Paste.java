package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.recorder.Recorder;

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

    public Paste(Receiver r) {
        this.receiver = r;
    }

    public Paste(int position){
        this.position = position;
    }

    /**
     */
    public void execute() {
        this.receiver.paste(this.position);
    }

    /**
     * @param r 
     */
    public void setReceiver(Receiver r) {
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
     * @return true if position is negative false otherwise.
     */
    public boolean isNegative(){
        return this.position < 0;
    }

    /**
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}