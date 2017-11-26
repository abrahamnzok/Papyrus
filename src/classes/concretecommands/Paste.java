package classes.concretecommands;

import classes.concretemementos.PasteGhost;
import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 * 
 */
public class Paste implements Command, Recordable {

    /**
     *
     */
    private Receiver receiver;

    /**
     *
     */
    private int position;

    /**
     * Default constructor
     */
    public Paste() {
        this.position = 0;
    }

    public Paste(int position){
        this.position = position;
    }

    /**
     */
    public void execute() {
        this.receiver.paste(this.position);
    }

    /**
     * @param r 
     */
    public void setReceiver(Receiver r) {
        this.receiver = r;
    }

    /**
     *  @param position where to paste
     */
    public void setPaste(int position){
        this.position = position;
    }

    /**
     * @return position where we pasted
     */
    public int getPaste(){
        return this.position;
    }

    /**
     * @return true if position is negative false otherwise.
     */
    public boolean isNegative(){
        return this.position < 0;
    }


    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new PasteGhost(this.receiver, this.position);
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {
        if(m != null && PasteGhost.class.isInstance(m)){
            this.receiver = ((PasteGhost) m).getReceiver();
            this.position = ((PasteGhost) m).getPositionState();
        }
    }
}