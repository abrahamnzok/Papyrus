package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * Immutable {@link Memento} of the recordable command {@link classes.recordablecommands.SelectionRecordable}
 */
public class SelectGhost implements Memento {

    /**
     *{@code int} to hold state of the starting point' state of selection
     */
    private int startState;

    /**
     *{@code int} to hold state of the ending point' state of selection
     */
    private int endState;

    /**
     *{@link Receiver} to hold the state of the receiver
     */
    private Receiver receiver;

    /**
     *
     * @param receiver {@link Receiver} state
     * @param startState state of the starting point of selection
     * @param endState  state of the ending point of selection
     */
    public SelectGhost(Receiver receiver, int startState, int endState) {
        this.receiver = receiver;
        this.startState = startState;
        this.endState = endState;
    }

    /**
     * @return the state of the starting point of selection
     */
    public int getStartState(){
        return this.startState;
    }

    /**
     * @return the state of the ending point of selection
     */
    public int getEndState(){
        return this.endState;
    }

    /**
     * @return receiver'state
     */
    public Receiver getReceiver(){
        return this.receiver;
    }
}