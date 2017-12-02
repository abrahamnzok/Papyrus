package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * Immutable {@link Memento} of the recordable command {@link classes.recordablecommands.PasteRecordable}
 */
public class PasteGhost implements Memento {

    /**
     *{@code int} to hold state of the position
     */
    private int positionState;

    /**
     *{@link Receiver} to hold the state of the receiver
     */
    private Receiver receiverState;


    /**
     * @param receiverState {@link Receiver} state
     * @param positionState position state
     */
    public PasteGhost(Receiver receiverState, int positionState) {
        this.receiverState = receiverState;
        this.positionState = positionState;
    }

    /**
     * @return position' state
     */
    public int getPositionState(){
        return this.positionState;
    }

    /**
     *
     * @return receiver' state
     */
    public Receiver getReceiver(){
        return this.receiverState;
    }

}