package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

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
     * Default constructor
     */
    public SelectGhost() {
    }

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

    protected void setStartState(int startState) {
        this.startState = startState;
    }

    protected void setEndState(int endState) {
        this.endState = endState;
    }

    public Receiver getReceiver(){
        return this.receiver;
    }
}