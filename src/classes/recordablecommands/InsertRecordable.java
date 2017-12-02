package classes.recordablecommands;

import classes.concretecommands.Insert;
import classes.concretemementos.InsertGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

/**
 * Subclass inheriting properties from {@link Insert}
 */
public class InsertRecordable extends Insert implements Recordable {

    /**
     * {@link Recorder} to perform the action of storing a command when is to be executed
     */
    private Recorder recorder;

    /**
     * Default constructor
     */
    public InsertRecordable() {
        super();
    }

    /**
     *{@inheritDoc}
     */
    public InsertRecordable(String textinput, int position) {
        super(textinput, position);
    }

    /**
     *{@inheritDoc}
     *@throws NoSuchMethodException
     */
    @Override
    public void execute() throws NoSuchMethodException {
        ((Carecorder) this.recorder).record(this.save(), this);
        super.execute();
    }

    /**
     * @return {@link Memento} which holds the state of {@link InsertRecordable}
     */
    @Override
    public Memento save() {
        return new InsertGhost(super.getReceiver(), super.getTextinput(), super.getPosition());
    }

    /**
     * @param m {@link Memento} to restore
     */
    @Override
    public void restore(Memento m) throws NoSuchMethodException {
        if( m != null && InsertGhost.class.isInstance(m)){
            super.setReceiver(((InsertGhost)m).getReceiver());
            super.setTextinput(((InsertGhost) m).getInputState());
            super.setPosition(((InsertGhost) m).getPositionState());
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
