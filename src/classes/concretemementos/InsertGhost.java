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
    private String textState;

    /**
     *
     */
    private int positionState;

    /**
     *
     */
    public Receiver receiverState;

    /**
     * Default constructor
     */
    public InsertGhost() {
    }

    /**
     * Preferred constructor
     */
    public InsertGhost(Receiver receiverState,String textState, int positionState) {
        this.receiverState  =receiverState;
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

    /*
     *
     */

    public Receiver getReceiver(){
        return this.receiverState;
    }


}