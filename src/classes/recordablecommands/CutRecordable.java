package classes.recordablecommands;

import classes.components.Carecorder;
import classes.concretecommands.Cut;
import classes.concretemementos.CutGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

/**
 * Subclass inheriting properties from {@link Cut}
 */
public class CutRecordable extends Cut implements Recordable {

    /**
     * {@link Recorder} to perform the action of storing a command when is to be executed
     */
    private Recorder recorder;

    /**
     * Defaut Constructor
     */
    public CutRecordable(){
        super();
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
     * @return {@link Memento} which holds the state of {@link CutRecordable}
     */
    @Override
    public Memento save() {
        return new CutGhost(super.getReceiver());
    }

    /**
     * @param m {@link Memento} to restore
     */
    @Override
    public void restore(Memento m) throws NoSuchMethodException {
        if(m != null && CutGhost.class.isInstance(m)){
            super.setReceiver(((CutGhost) m).getReceiver());
            super.execute();
        }
    }

    /**
     * @param recorder new Receiver that know how to record this
     */
    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }

}
