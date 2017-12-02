package classes.recordablecommands;

import classes.concretecommands.Delete;
import classes.concretemementos.DeleteGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

/**
 * Subclass inheriting properties from {@link Delete}
 */
public class DeleteRecordable extends Delete implements Recordable {

    /**
     * {@link Recorder} to perform the action of storing a command when is to be executed
     */
    private Recorder recorder;

    /**
     * Default constructor
     */
    public DeleteRecordable() {
        super();
    }

    /**
     *{@inheritDoc}
     */
    public DeleteRecordable(int position) {
        super(position);
    }

    /**
     *{@inheritDoc}
     * @throws NoSuchMethodException
     */
    @Override
    public void execute() throws NoSuchMethodException {
        ((Carecorder) this.recorder).record(this.save(), this);
        super.execute();
    }

    /**
     * @return {@link Memento} which holds the state of {@link DeleteRecordable}
     */
    @Override
    public Memento save() {
        return new DeleteGhost(super.getReceiver(), super.getPosition());
    }

    /**
     * @param m {@link Memento} to restore
     */
    @Override
    public void restore(Memento m) throws NoSuchMethodException {
        if( m != null && DeleteGhost.class.isInstance(m)){
            super.setReceiver(((DeleteGhost) m).getReceiver());
            super.setPosition(((DeleteGhost) m).getPositionState());
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
