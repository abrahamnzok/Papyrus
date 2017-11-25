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
}
