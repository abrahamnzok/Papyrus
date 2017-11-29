package classes.recordablecommands;

import classes.concretecommands.Selection;
import classes.concretemementos.SelectGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

public class SelectionRecordable extends Selection implements Recordable {

    /**
     *
     */
    private Recorder recorder;

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
     *
     */
    @Override
    public void execute() throws NoSuchMethodException {
        this.recorder.record(this.save());
        super.execute();
    }

    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new SelectGhost(super.getReceiver(), super.getStart(), super.getEnd());
    }

    /**
     * @param m memento state we want to restore to the originator
     */
    @Override
    public void restore(Memento m) {
        if( m != null && SelectGhost.class.isInstance(m)){
            super.setStart(((SelectGhost) m).getStartState());
            super.setEnd(((SelectGhost) m).getEndState());
            super.setReceiver(((SelectGhost) m).getReceiver());
        }
    }

    /*
     *
     */
    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }
}
