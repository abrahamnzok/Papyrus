package classes.v1.concretecommands;

import interfaces.v1.command.Command;
import interfaces.v2.recorder.Recorder;

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
     * @param carecorder
     */
    public void setReceiver(Recorder carecorder) {
        // TODO implement here
        this.recorder = carecorder;
    }

}