package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;

/**
 *
 */
public class Delete implements Command {


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
    public void execute() throws NoSuchMethodException {
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
     * @param position of the character to delete
     */
    public void setPosition(int position){
        this.position = position;
    }

    /**
     * @return position where to delete
     */
    public int getPosition(){
        return this.position;
    }

    /**
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}
