package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;
import interfaces.recorder.Recorder;

/**
 * 
 */
public class Insert implements Command {

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

    public Insert(String textToInsert, int position){
        this.setPosition(position);
        this.textinput = textToInsert;
        this.position = this.getPosition() ;
    }

    public void execute() throws NoSuchMethodException {
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
     *
     */
    public Receiver getReceiver() {
        return this.receiver;
    }

}