package classes.recordablecommands;

import classes.concretecommands.Copy;
import classes.concretemementos.CopyGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

/**
 * Subclass inheriting properties from {@link Copy}
 */
public class CopyRecordable extends Copy implements Recordable {

    /**
     * {@link Recorder} to perform the action of storing a command when is to be executed
     */
    private Recorder recorder;

    /**
     * Defaut Constructor
     */
    public CopyRecordable(){
        super();
    }

    /**
     * {@inheritDoc}
     * @throws NoSuchMethodException
     */
    @Override
    public void execute() throws NoSuchMethodException {
        this.recorder.record(this.save(), this);
        super.execute();
    }

    /**
     * @return {@link Memento} which holds the state of {@link CopyRecordable}
     */
    @Override
    public Memento save() {
        return new CopyGhost(super.getReceiver());
    }

    /**
     * @param m {@link Memento} to restore
     */
    @Override
    public void restore(Memento m) throws NoSuchMethodException {
        if( m != null && CopyGhost.class.isInstance(m)){
            super.setReceiver(((CopyGhost)m).getReceiver());
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
