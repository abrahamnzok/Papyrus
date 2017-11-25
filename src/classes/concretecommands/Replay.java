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
        // TODO implement here
        this.recorder.replayCommands();
    }

    /**
     * @param c  
     */
    public void setReceiver(Recorder carecorder) {
        // TODO implement here
        this.recorder = carecorder;
    }

}