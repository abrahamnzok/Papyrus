package classes.concretecommands;

import classes.components.Carecorder;
import interfaces.command.Command;
import interfaces.recorder.Recorder;

public class Stop implements Command {

    /**
     *
     */
    private Recorder recorder;

    /**
     *
     */
    @Override
    public void execute() {
        ((Carecorder) this.recorder).stoprecording();
    }

    /**
     * @param recorder is the receiver to perform the recording
     */
    public void setReceiver(Recorder recorder) {
        // TODO implement here
        this.recorder = recorder;
    }
}
