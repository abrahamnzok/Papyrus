package classes.components;

import interfaces.memento.Memento;
import interfaces.recorder.Recorder;

public class Carecorder implements Recorder {
    /**
     * @param memento to store
     */
    @Override
    public void recordCommands(Memento memento) {

    }

    /**
     *
     */
    @Override
    public Memento replayCommands() {
        return null;
    }

    /**
     *
     */
    @Override
    public void stopRecordingCommand() {

    }
}
