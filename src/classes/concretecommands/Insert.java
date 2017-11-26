package classes.concretecommands;

import classes.concretemementos.InsertGhost;
import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 * 
 */
public class Insert implements Command, Recordable {

    private Receiver receiver;
    private String textinput;
    private int position;

    /**
     * Default constructor
     */
    public Insert() {
        this.textinput = "";
        this.position = 0;
    }

    public Insert(String textinput, int position){
        this.setPosition(position);
        this.textinput = textinput;
        this.position = this.getPosition() ;
    }

    public void execute() {
        this.receiver.insert(this.textinput, this.position);
    }

    /**
     * @param r Receiver which will execute the task
     */
    public void setReceiver(Receiver r) {
        this.receiver = r;
    }

    /**
     * @return textinput
     */
    public String getTextinput() {
        return this.textinput;
    }

    /**
     * @param textinput text that we need to insert
     * @return
     */
    public void setTextinput(String textinput) {
        this.textinput = textinput;
    }

    /**
     * @return the position of where to insert
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * @param position where to insert a text
     */
    public void setPosition(int position) {
        if(!this.isNegative()) {
            this.position = position;
        }
    }

    /**
     * @return boolean
     */
    public boolean isNegative(){
        return this.position < 0;
    }


    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new InsertGhost(this.receiver, this.textinput, this.position);
    }

    /**
     * @param m from which we will retrieve savedState
     */
    @Override
    public void restore(Memento m) {
        if( m != null && InsertGhost.class.isInstance(m)){
            this.receiver = ((InsertGhost) m).getReceiver();
            this.textinput = ((InsertGhost) m).getTextState();
            this.position = ((InsertGhost) m ).getPositionState();
        }
    }
}