package classes.concretemementos;

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
     * Default constructor
     */
    public DeleteGhost(int positionState) {
        this.positionState = positionState;
    }

    /*
     *
     */

    public int getPositionState(){
        return this.positionState;
    }


}