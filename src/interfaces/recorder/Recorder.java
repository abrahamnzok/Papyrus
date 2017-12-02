package interfaces.recorder;

import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 * 
 */
public interface Recorder {

    /**
     * @param memento to store
     * @param recordable reference to the originator
     */
    void record(Memento memento, Recordable recordable) throws NoSuchMethodException;

    /**
     * Sets on the action of replaying
     */
    void replay();

    /**
     * Sets on the action of recording
     */
    void setrecording();

    /**
     * Sets off the action of recording
     *
     */
    void stoprecording();

}