package classes.recordablecommands;

import classes.concretecommands.Paste;
import classes.concretemementos.PasteGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;
/**
 * Subclass inheriting properties from {@link Paste}
 */
public class PasteRecordable extends Paste implements Recordable {

    /**
     * {@link Recorder} to perform the action of storing a command when is to be executed
     */
    private Recorder recorder;

    /**
     * Default constructor
     */
    public PasteRecordable() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public PasteRecordable(int position) {
        super(position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws NoSuchMethodException {
        this.recorder.record(this.save(), this);
        super.execute();
    }

    /**
     * @return {@link Memento} which holds the state of {@link PasteRecordable}
     */
    @Override
    public Memento save() {
        return new PasteGhost(super.getReceiver(),super.getPaste());
    }

    /**
     * @param m {@link Memento} to restore
     */
    @Override
    public void restore(Memento m) throws NoSuchMethodException {
        if(m != null && PasteGhost.class.isInstance(m)){
            super.setReceiver(((PasteGhost) m).getReceiver());
            super.setPaste(((PasteGhost) m).getPositionState());
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
