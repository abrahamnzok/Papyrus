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
     *
     */
    private Recorder carecorder;

    /**
     * Default constructor
     */
    public Cut() {
    }

    public Cut(Receiver r) {
        this.receiver = r;
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
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}