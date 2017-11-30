package classes.recordablecommands;

import classes.concretecommands.Delete;
import classes.concretemementos.DeleteGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

public class DeleteRecordable extends Delete implements Recordable {

    /**
     *
     */
    private Recorder recorder;

    /**
     * Default constructor
     */
    public DeleteRecordable() {
        super();
    }

    /**
     * Preferred constructor
     *
     * @param position
     */
    public DeleteRecordable(int position) {
        super(position);
    }

    /**
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
        return new DeleteGhost(super.getReceiver(), super.getPosition());
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {
        if( m != null && DeleteGhost.class.isInstance(m)){
            super.setReceiver(((DeleteGhost) m).getReceiver());
            super.setPosition(((DeleteGhost) m).getPositionState());
        }
    }

    /**
     *
     */
    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }
}
