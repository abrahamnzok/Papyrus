package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.recorder.Recorder;

/**
 * 
 */
public class Cut implements Command{


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
    public void execute() throws NoSuchMethodException {
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
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}