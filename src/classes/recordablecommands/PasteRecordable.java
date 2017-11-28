package classes.recordablecommands;

import classes.concretecommands.Paste;
import classes.concretemementos.PasteGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class PasteRecordable extends Paste implements Recordable {


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
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new PasteGhost(super.getReceiver(),super.getPaste());
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {
        if(m != null && PasteGhost.class.isInstance(m)){
            super.setReceiver(((PasteGhost) m).getReceiver());
            super.setPaste(((PasteGhost) m).getPositionState());
        }
    }
}
