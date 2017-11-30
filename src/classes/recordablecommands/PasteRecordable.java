package classes.recordablecommands;

import classes.concretecommands.Paste;
import classes.concretemementos.PasteGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

public class PasteRecordable extends Paste implements Recordable {

    /**
     *
     */
    private Recorder recorder;

    /**
     * Default constructor
     */
    public PasteRecordable() {
        super();
    }

    /*
     * Preferred constructor
     */
    public PasteRecordable(int position) {
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
        return new PasteGhost(super.getReceiver(),super.getPaste());
    }

    /**
     * @param m memento's state we want to restore to the originator
     */
    @Override
    public void restore(Memento m) {
        if(m != null && PasteGhost.class.isInstance(m)){
            super.setReceiver(((PasteGhost) m).getReceiver());
            super.setPaste(((PasteGhost) m).getPositionState());
        }
    }

    public void setRecorder(Recorder recorder){
        this.recorder = recorder;
    }
}
