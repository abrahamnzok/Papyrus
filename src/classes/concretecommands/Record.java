package classes.concretecommands;

import classes.components.Carecorder;
import interfaces.command.Command;
import interfaces.recorder.Recorder;

public class Record implements Command {

    /**
     *
     */
    private Recorder recorder;

    /**
     *
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
