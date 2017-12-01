package classes.recordablecommands;

import classes.concretecommands.Copy;
import classes.concretemementos.CopyGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

public class CopyRecordable extends Copy implements Recordable {

    /**
     *
     */
    private Recorder recorder;

    /**
     * Defaut Constructor
     */
    public CopyRecordable(){
        super();
    }

    /**
     */
    @Override
    public void execute() throws NoSuchMethodException {
        ((Carecorder) this.recorder).record(this.save(), this);
        super.execute();
    }

    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new CopyGhost(super.getReceiver());
    }

    /**
     * @param m to restore
     */
    @Override
    public void restore(Memento m) throws NoSuchMethodException {
        if( m != null && CopyGhost.class.isInstance(m)){
            super.setReceiver(((CopyGhost)m).getReceiver());
            super.execute();
        }
    }

    /**
     *
     * @param recorder new Receiver that know how to record this
     */
    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }
}
