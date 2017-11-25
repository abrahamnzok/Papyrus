package classes.concretemementos;

import interfaces.memento.Memento;

/**
 * 
 */
public class InsertGhost implements Memento {

    /**
     *
     */
    public String textState;

    /**
     *
     */
    public int positionState;

    /**
     * Default constructor
     */
    public InsertGhost() {
    }

    /**
     * Preferred constructor
     */
    public InsertGhost(String textState, int positionState) {
        this.textState = textState;
        this.positionState = positionState;
    }

    /**
     *
     */
    public void setTextState(String state){
        this.textState = state;
    }

    /**
     *
     */
    public int getPositionState(){
        return this.positionState;
    }

    /**
     *
     */
    public String getTextState(){
        return this.textState;
    }


}