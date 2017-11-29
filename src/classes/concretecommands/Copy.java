package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

public class Copy implements Command{

    /**
     *
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public Copy() {
    }

    public Copy(Receiver r) {
        this.receiver = r;
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
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}
