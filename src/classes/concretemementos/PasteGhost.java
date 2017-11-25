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
    public int position;

    /**
     * Default constructor
     */
    public PasteGhost() {
    }

    /*
    *
    */
    public int getPositionState(){
        return 0;
    }

}