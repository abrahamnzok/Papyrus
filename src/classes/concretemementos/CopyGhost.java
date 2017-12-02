package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * Immutable Object Memento of the recordable command CopyRecordable
 */
public class CopyGhost implements Memento {

    /**
     *{@link Receiver} state
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public CopyGhost(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the state of the receiver
     */
    public Receiver getReceiver() {
        return this.receiver;
    }
}