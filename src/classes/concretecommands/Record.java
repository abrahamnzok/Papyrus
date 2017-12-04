package classes.concretecommands;

import classes.components.Carecorder;
import interfaces.command.Command;
import interfaces.recorder.Recorder;

/**
 * Record Command
 */
public class Record implements Command {

    /**
     * Receiver that takes care of the recording and replaying tasks
     */
    private Recorder recorder;

    /**
     * executes the action to be performed by the receiver
     */
    @Override
    public void execute() {
        ((Carecorder) this.recorder).setrecording();
    }

    /**
     * @param recorder is the receiver to perform the recording
     */
    public void setReceiver(Recorder recorder) {
        // TODO implement here
        this.recorder = recorder;
    }
}
