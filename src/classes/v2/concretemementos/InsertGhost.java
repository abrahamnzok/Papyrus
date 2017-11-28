package classes.v2.concretemementos;

import interfaces.v1.Receiver.Receiver;
import interfaces.v2.memento.Memento;

/**
 * 
 */
public class InsertGhost implements Memento {

    /**
     *
     */
    private String textState;

    /**
     *
     */
    private int positionState;

    /**
     *
     */
    private Receiver receiverState;

    /**
     * Preferred constructor
     */
    public InsertGhost(Receiver receiverState,String textState, int positionState) {
        this.receiverState  =receiverState;
        this.textState = textState;
        this.positionState = positionState;
    }

    public int getPositionState(){
        return this.positionState;
    }

    /**
     *
     */
    public String getTextState(){
        return this.textState;
    }

    /*
     *
     */

    public Receiver getReceiver(){
        return this.receiverState;
    }


}