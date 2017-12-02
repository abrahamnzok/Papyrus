package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * Immutable {@link Memento} of the recordable command {@link classes.recordablecommands.DeleteRecordable}
 */
public class DeleteGhost implements Memento {

    /**
     *{@code int} to hold state of the position
     */
    private int positionState;

    /**
     *{@link Receiver} to hold the state of the receiver
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public DeleteGhost(Receiver receiver, int positionState) {
        this.receiver = receiver;
        this.positionState = positionState;
    }

    /**
     * @return position's state
     */
    public int getPositionState(){
        return this.positionState;
    }

    /**
     * @return receiver's state
     */
    public Receiver getReceiver(){
        return this.receiver;
    }


}