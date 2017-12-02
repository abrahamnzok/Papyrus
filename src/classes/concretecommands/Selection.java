package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.recorder.Recorder;

/**
 * Record Command
 */
public class Selection implements Command {

    /**
     * {@link Recorder} to perform the action when the command is to be executed
     */
    private Receiver receiver;

    /**
     * {@code int} hold the value of the starting point of selection
     */
    private int start;

    /**
     * {@code int} hold the value of the ending point of selection
     */
    private int end;

    /**
     * Preferred Constructor
     * @param start starting point of selection
     * @param end ending point of selection
     */
    public Selection(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Default constructor
     */
    public Selection() {
        this.start = 0;
        this.end = 0;
    }

    /**
     * executes the action to be performed by the receiver
     * @throws NoSuchMethodException
     */
    public void execute() throws NoSuchMethodException {
        // TODO implement here
        this.receiver.select(this.start, this.end);
    }

    /**
     * @param r Receiver which will execute the task
     */
    public void setReceiver(Receiver r) {
        // TODO implement here
        this.receiver = r;
    }

    /**
     * setting start of selection
     */
    public void setStart(int start){
        this.start = start;
    }

    /**
     * setting end of selection
     */
    public void setEnd(int end){
        this.end = end;
    }

    /**
     * @return start of selection
     */
    public int getStart(){
        return this.start;
    }

    /**
     * @return end of selection
     */
    public int getEnd(){
        return this.end;
    }

    /**
     * @return receiver
     */
    public Receiver getReceiver() {
        return this.receiver;
    }
}
