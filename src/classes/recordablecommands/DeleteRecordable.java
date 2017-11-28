package classes.recordablecommands;

import classes.concretecommands.Delete;
import classes.concretemementos.DeleteGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class DeleteRecordable extends Delete implements Recordable {

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
}
