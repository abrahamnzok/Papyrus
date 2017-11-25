package classes.concretemementos;

import interfaces.Receiver.Receiver;
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
    public InsertGhost(String textState, int positionState) {
    }

    /**
     *
     */
    public int getStartState(){
        return 0;
    }

    /**
     *
     */
    public int getEndState(){
        return 0;
    }



}