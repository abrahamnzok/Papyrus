package classes.v2.concretemementos;

import interfaces.v1.Receiver.Receiver;
import interfaces.v2.memento.Memento;

/**
 * 
 */
public class PasteGhost implements Memento {

    /**
     *
     */
    private int positionState;

    /**
     *
     */
    private Receiver receiverState;


    /**
     * Default constructor
     */
    public PasteGhost(Receiver receiverState, int positionState) {
        this.receiverState = receiverState;
        this.positionState = positionState;
    }

    /*
    *
    */
    public int getPositionState(){
        return this.positionState;
    }

    public Receiver getReceiver(){
        return this.receiverState;
    }

}