package classes.concretecommands;

import classes.concretemementos.DeleteGhost;
import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 *
 */
public class Delete implements Command, Recordable {


    private int position;
    /**
     *
     */
    private Receiver receiver;

    /**
     * Default constructor
     */
    public Delete() {
        this.position = 0;
    }

    /**
     * Preferred constructor
     */
    public Delete(int position) {
        this.position = position;
    }

    /**
     */
    public void execute() {
        // TODO implement here
        this.receiver.delete(this.position);
    }

    /**
     * @param r Receiver which will execute the task
     */
    public void setReceiver(Receiver r) {
        // TODO implement here
        this.receiver = r;
    }

    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new DeleteGhost(this.receiver, this.position);
    }

    /**
     * @param m from Which we will retrieve savedStates
     */
    @Override
    public void restore(Memento m) {
        if( m != null && DeleteGhost.class.isInstance(m)){
            this.receiver = ((DeleteGhost) m).getReceiver();
            this.position = ((DeleteGhost) m).getPositionState();
        }
    }

    /**
     * @param position of the character to delete
     */
    protected void setPosition(int position){
        this.position = position;
    }

    /**
     * @return position where to delete
     */
    public int getPosition(){
        return this.position;
    }

}
