package classes.v1.concretecommands;

import interfaces.v1.command.Command;
import interfaces.v2.recorder.Recorder;

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
    private Command command;

    /**
     * Default constructor
     */
    public Record() {
    }

    /**
     *
     */
    public void execute() {
        this.recorder.record(this.command);
    }

    /**
     * @param carecorder the Object that knows how to store
     */
    public void setReceiver(Recorder carecorder) {
        this.recorder = carecorder;
    }

    /**
     * @param command to record
     */
    public void setRecordable(Command command){
        this.command = command;
    }

}