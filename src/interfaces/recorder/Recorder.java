package interfaces.recorder;

import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 * 
 */
public interface Recorder {
    /**
     * @param memento  to store
     */
    public void record(Memento memento);

    /**
     *
     */
    public void replay();

    /**
     *
     */
    public void setRecording(boolean record);

    /**
     *
     */
    public boolean isRecording();

    /**
     *
     */
    public void stop();

}