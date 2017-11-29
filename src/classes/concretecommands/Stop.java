package classes.concretecommands;

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

    }

    /**
     * @param recorder is the receiver to perform the recording
     */
    public void setReceiver(Recorder recorder) {
        // TODO implement here
    }
}
