package classes.concretecommands;


import interfaces.command.Command;
import interfaces.recorder.Recorder;

/**
 * 
 */
public class Replay implements Command {

    /**
     *
     */
    private Recorder recorder;

    /**
     * Default constructor
     */
    public Replay() {
    }

    /**
     *
     */
    public void execute() {
    }

    /**
     * @param carecorder the Object that knows how to store
     */
    public void setReceiver(Recorder carecorder) {
        this.recorder = carecorder;
    }

}