package interfaces.recordable;

import interfaces.memento.Memento;

/**
 * 
 */
public interface Recordable {

    /**
     * @return Specific Memento for the specific Recordable
     */
    Memento save();

    /**
     * @param m
     */
    void restore(Memento m) throws NoSuchMethodException;

}