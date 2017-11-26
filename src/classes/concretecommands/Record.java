package classes.concretecommands;

import interfaces.command.Command;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

/**
 * 
 */
public class Record implements Command {

    /**
     *
     */
    private Recorder recorder;

    /**
     *
     */
    private Recordable recordable;

    /**
     * Default constructor
     */
    public Record() {
    }

    /**
     *
     */
    public void execute() {
        this.recorder.record(this.recordable.save());
    }

    /**
     * @param c the Object that knows how to store
     */
    public void setReceiver(Recorder carecorder) {
        this.recorder = carecorder;
    }

    /**
     * @param command to record
     */
    public void setRecordable(Recordable recordable){
        this.recordable= recordable;
    }

}