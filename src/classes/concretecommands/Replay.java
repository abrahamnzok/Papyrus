package classes.concretecommands;

import classes.components.Carecorder;
import interfaces.command.Command;
import interfaces.recorder.Recorder;

public class Replay implements Command {

    /**
     *
     */
    private Recorder recorder;

    /**
     *
     */
    @Override
    public void execute() {
        ((Carecorder) this.recorder).replay();
    }

    /**
     * @param recorder is the receiver to perform the recording
     */
    public void setReceiver(Recorder recorder) {
        this.recorder = recorder;
    }
}
