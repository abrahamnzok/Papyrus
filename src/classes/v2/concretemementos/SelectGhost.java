package classes.v2.concretemementos;

import interfaces.v1.Receiver.Receiver;
import interfaces.v2.memento.Memento;

/**
 * 
 */
public class SelectGhost implements Memento {

    /**
     *
     */
    private int startState;

    /**
     *
     */
    private int endState;

    /**
     *
     */
    private Receiver receiver;

    /**
     * Preferred constructor
     */
    public SelectGhost(Receiver receiver, int startState, int endState) {
        this.receiver = receiver;
        this.startState = startState;
        this.endState = endState;
    }

    /**
     *
     */
    public int getStartState(){
        return this.startState;
    }

    public int getEndState(){
        return this.endState;
    }

    public Receiver getReceiver(){
        return this.receiver;
    }
}