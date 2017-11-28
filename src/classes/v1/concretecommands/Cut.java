package classes.v1.concretecommands;

import interfaces.v1.Receiver.Receiver;
import interfaces.v1.command.Command;
import interfaces.v2.memento.Memento;
import interfaces.v2.recordable.Recordable;

/**
 * 
 */
public class Cut implements Command, Recordable {


    /**
     *
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public Cut() {
    }


    /**
     */
    public void execute() {
        // TODO implement here
        this.receiver.cut();
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