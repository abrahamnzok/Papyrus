package classes.concretecommands;

import interfaces.command.Command;
import interfaces.recorder.Recorder;

/**
 * 
 */
public class Stop implements Command {

    /**
     *
     */
    private Recorder recorder;


    /**
     * Default constructor
     */
    public Stop() {
    }

    /**
     * @return
     */
    public void execute() {
        // TODO implement here
        this.recorder.stop();
    }

    /**
     * @param c 
     */
    public void setReceiver(Recorder carecorder) {
        // TODO implement here
        this.recorder = carecorder;
    }

}