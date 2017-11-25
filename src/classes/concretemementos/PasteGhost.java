package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * 
 */
public class PasteGhost implements Memento {

    /**
     *
     */
    private int positionState;

    /**
     * Default constructor
     */
    public PasteGhost(int positionState) {
        this.positionState = positionState;
    }

    /*
    *
    */
    public int getPositionState(){
        return this.positionState;
    }

}