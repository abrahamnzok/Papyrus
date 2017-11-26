package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * 
 */
public class CopyGhost implements Memento {

    /*
     *
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public CopyGhost(Receiver receiver) {
        this.receiver = receiver;
    }

    /*
     *
     */

    public Receiver getReceiver() {
        return this.receiver;
    }
}