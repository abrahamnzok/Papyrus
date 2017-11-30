package classes.recordablecommands;

import classes.concretecommands.Cut;
import classes.concretemementos.CutGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

public class CutRecordable extends Cut implements Recordable {

    /**
     *
     */
    private Recorder recorder;

    /**
     *
     */
    public CutRecordable(){
        super();
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
        return new CutGhost(super.getReceiver());
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {
        if(m != null && CutGhost.class.isInstance(m)){
            super.setReceiver(((CutGhost) m).getReceiver());
        }
    }

    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }

}
