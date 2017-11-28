package classes.v2.concretemementos;

import interfaces.v1.Receiver.Receiver;
import interfaces.v2.memento.Memento;

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