package classes.concretecommands;

import interfaces.command.Command;
import interfaces.recorder.Recorder;

public class Stop implements Command {

    /**
     * Receiver that takes care of the recording and replaying tasks
     */
    private Recorder recorder;

    /**
     * executes the action to be performed by the receiver
     */
    @Override
    public void execute() {
        this.recorder.stoprecording();
    }

    /**
     * @param recorder is the receiver to perform the recording
     */
    public void setReceiver(Recorder recorder) {
        // TODO implement here
        this.recorder = recorder;
    }
}
