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
    public void replay(Recordable recordable);

    /**
     *
     */
    public void stop();

}