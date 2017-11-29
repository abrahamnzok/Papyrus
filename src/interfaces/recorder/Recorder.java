package interfaces.recorder;

import interfaces.memento.Memento;

/**
 * 
 */
public interface Recorder {
    /**
     * @param memento  to store
     */
    void record(Memento memento);

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
    boolean isrecording();

    /**
     *
     */
    void stoprecording();

}