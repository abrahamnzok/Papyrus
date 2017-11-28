package classes.recordablecommands;

import classes.concretecommands.Selection;
import classes.concretemementos.SelectGhost;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

public class SelectionRecordable extends Selection implements Recordable {

    private Recorder recorder;

    /**
     *
     */
    @Override
    public void execute() {
        super.execute();
    }

    /**
     * Default constructor
     */
    public SelectionRecordable() {
        super();
    }

    /**

     * Preferred Constructor
     *
     * @param start starting point of selection
     * @param end  ending point of selection
     */
    public SelectionRecordable(int start, int end) {
        super(start, end);

    }

    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new SelectGhost(super.getReceiver(), super.getStart(), super.getEnd());
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {

    }

    /*
     *
     */
    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }
}
