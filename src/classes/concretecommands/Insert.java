package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

/**
 * 
 */
public class Insert implements Command, Recordable {

    private Receiver receiver;
    private String textToInsert;
    private int position;

    /**
     * Default constructor
     */
    public Insert() {
    }

    public Insert(String textToInsert, int position){
        this.setPosition(position);
        this.textToInsert = textToInsert;
        this.position = this.getPosition() ;
    }

    public void execute() {
        this.receiver.insert(this.textToInsert, this.position);
    }

    /**
     * @param r 
     * @return
     */
    public void setReceiver(Receiver r) {
        this.receiver = r;
    }

    /**
     * @return textToInsert
     */
    public String getTextToInsert() {
        return this.textToInsert;
    }

    /**
     * @param textToInsert text that we need to insert
     * @return
     */
    public void setTextToInsert(String textToInsert) {
        this.textToInsert = textToInsert;
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
        return null;
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {

    }
}