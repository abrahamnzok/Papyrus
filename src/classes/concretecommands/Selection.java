package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class Selection implements Command, Recordable {

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

    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return null;
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {

    }

    /*
    * setting start of selection from configurator
    */
    protected void setStart(int start){
        this.start = start;
    }

    /*
     * setting end of selection from the configurator
     */
    protected void setEnd(int end){
        this.end = end;
    }

    /*
     * @return start of selection from configurator
     */
    public int getStart(){
        return this.start;
    }

    /*
     * @return end of selection from the configurator
     */
    public int getEnd(){
        return this.end;
    }
}
