package interfaces.recordable;

import interfaces.memento.Memento;

/**
 * 
 */
public interface Recordable {

    /**
     * @return Specific Memento for the specific Recordable
     */
    public Memento save();

    /**
     * @param m
     */
    public void restore(Memento m);

}