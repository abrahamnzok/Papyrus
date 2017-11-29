package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * 
 */
public class DeleteGhost implements Memento {

    /**
     *
     */
    private int positionState;

    /**
     *
     */
    private Receiver receiver;

    /**
     *
     */

    public DeleteGhost(){

    }

    /**
     * Default constructor
     */
    public DeleteGhost(Receiver receiver, int positionState) {
        this.receiver = receiver;
        this.positionState = positionState;
    }

    /*
     *
     */
    public int getPositionState(){
        return this.positionState;
    }

    /*
     *
     */
    public Receiver getReceiver(){
        return this.receiver;
    }


}