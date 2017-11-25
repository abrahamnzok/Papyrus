package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 *
 */
public class Delete implements Command, Recordable {


    private int position;
    /**
     *
     */
    private Receiver receiver;


    /**
     * Default constructor
     */
    public Delete(int position) {
        this.position = position;
    }

    /**
     */
    public void execute() {
        // TODO implement here
        this.receiver.delete(this.position);
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
