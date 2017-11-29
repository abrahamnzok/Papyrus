package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;

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
     */
    public void execute() {
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

    /*
    * setting start of selection
    */
    public void setStart(int start){
        this.start = start;
    }

    /*
     * setting end of selection
     */
    public void setEnd(int end){
        this.end = end;
    }

    /*
     * @return start of selection
     */
    public int getStart(){
        return this.start;
    }

    /*
     * @return end of selection
     */
    public int getEnd(){
        return this.end;
    }

    /**
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }
}
