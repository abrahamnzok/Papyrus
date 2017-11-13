package Classes.ConcreteCommands;

import Interfaces.Command.Command;
import Interfaces.Receiver.Receiver;

import java.util.*;

/**
 * 
 */
public class Insert implements Command {

    private Receiver receiver;
    private String textToInsert;
    private int position;

    /**
     * Default constructor
     */
    public Insert() {
    }

    public Insert(String textToInsert, int position){
        this.textToInsert = textToInsert;
        this.position = (int) position;
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


    public String getTextToInsert() {
        return this.textToInsert;
    }

    public void setTextToInsert(String textToInsert) {
        this.textToInsert = textToInsert;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}