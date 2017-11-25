package interfaces.recorder;

import interfaces.memento.Memento;

/**
 * 
 */
public interface Recorder {
    /**
     * @param memento  to store
     */
    public void recordCommands(Memento memento);

    /**
     *
     */
    public Memento replayCommands();

    /**
     *
     */
    public void stopRecordingCommand();

}