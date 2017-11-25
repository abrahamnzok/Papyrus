package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class Copy implements Command, Recordable {

    /**
     *
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public Copy() {
    }


    /**
     */
    public void execute() {
        // TODO implement here
        this.receiver.copy();
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
