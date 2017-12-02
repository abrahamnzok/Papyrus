package classes.recordablecommands;

import classes.concretecommands.Selection;
import classes.concretemementos.SelectGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;
/**
 * Subclass inheriting properties from {@link Selection}
 */
public class SelectionRecordable extends Selection implements Recordable {

    /**
     * {@link Recorder} to perform the action of storing a command when is to be executed
     */
    private Recorder recorder;

    /**
     * Default constructor
     */
    public SelectionRecordable() {
        super();
    }

    /**
     *{@inheritDoc}
     */
    public SelectionRecordable(int start, int end) {
        super(start, end);

    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchMethodException {
        this.recorder.record(this.save(), this);
        super.execute();
    }

    /**
     * @return {@link Memento} which holds the state of {@link SelectionRecordable}
     */
    @Override
    public Memento save() {
        return new SelectGhost(super.getReceiver(), super.getStart(), super.getEnd());
    }

    /**
     * @param m {@link Memento} to restore
     */
    @Override
    public void restore(Memento m) throws NoSuchMethodException {
        if( m != null && SelectGhost.class.isInstance(m)){
            super.setStart(((SelectGhost) m).getStartState());
            super.setEnd(((SelectGhost) m).getEndState());
            super.setReceiver(((SelectGhost) m).getReceiver());
            super.execute();
        }
    }

    /**
     * @param recorder new Receiver that knows how to record this
     */
    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }
}
