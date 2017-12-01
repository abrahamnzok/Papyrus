package interfaces.recorder;

import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 * 
 */
public interface Recorder {
    /**
     * @param memento  to store
     * @param recordable reference to the originator
     */
    void record(Memento memento, Recordable recordable) throws NoSuchMethodException;

}