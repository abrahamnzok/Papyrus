package classes.v2.concretemementos;


import interfaces.v1.Receiver.Receiver;
import interfaces.v2.memento.Memento;

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
    public Receiver receiver(){
        return this.receiver;
    }

}