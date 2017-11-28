package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * 
 */
public class CutGhost implements Memento {

    /*
     *
     */
    private Receiver receiver;


    /*
     * Default constructor
     */
    public CutGhost(Receiver receiver) {
        this.receiver = receiver;
    }

    /*
     *
     */
    public Receiver getReceiver(){
        return this.receiver;
    }

}