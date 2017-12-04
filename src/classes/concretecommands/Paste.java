package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.recorder.Recorder;

/**
 * Paste Command
 */
public class Paste implements Command {

    /**
     * {@link Receiver} to perform the action when the command is to be executed
     */
    private Receiver receiver;

    /**
     * {@code int} position where to paste
     */
    private int position;

    /**
     * Default constructor
     */
    public Paste() {
        this.position = 0;
    }

    /**
     *
     * @param position where to paste
     */
    public Paste(int position){
        this.position = position;
    }

    /**
     * executes the action to be performed by the receiver
     * @throws NoSuchMethodException
     */
    public void execute() throws NoSuchMethodException {
        this.receiver.paste(this.position);
    }

    /**
     * @param r receiver to perform the action when the command is to be executed
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
     * @return receiver
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}