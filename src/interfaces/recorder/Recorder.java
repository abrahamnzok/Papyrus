package interfaces.recorder;

import interfaces.memento.Memento;

/**
 * 
 */
public interface Recorder {
    /**
     * @param memento  to store
     * @param myclass the name of the class that created the memento
     */
    void record(Class myclass, Memento memento) throws NoSuchMethodException;

    /**
     *
     */
    void replay();

    /**
     *
     */
    void setrecording();

    /**
     *
     */
    void stoprecording();

}