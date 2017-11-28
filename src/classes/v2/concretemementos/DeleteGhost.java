package classes.v2.concretemementos;


import interfaces.v1.Receiver.Receiver;
import interfaces.v2.memento.Memento;

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