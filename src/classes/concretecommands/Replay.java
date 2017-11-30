package classes.concretecommands;

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
        this.recorder.replay();
    }

    /**
     * @param recorder is the receiver to perform the recording
     */
    public void setReceiver(Recorder recorder) {
        // TODO implement here
        this.recorder = recorder;
    }
}
