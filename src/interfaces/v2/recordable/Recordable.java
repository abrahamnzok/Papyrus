package interfaces.v2.recordable;

import interfaces.v2.memento.Memento;

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