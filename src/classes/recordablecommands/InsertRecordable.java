package classes.recordablecommands;

import classes.concretecommands.Insert;
import classes.concretemementos.InsertGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class InsertRecordable extends Insert implements Recordable {

    /**
     * Default constructor
     */
    public InsertRecordable() {
        super();
    }

    public InsertRecordable(String textinput, int position) {
        super(textinput, position);
    }

    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return new InsertGhost(super.getReceiver(), super.getTextinput(), super.getPosition());
    }

    /**
     * @param m memento's state we want to restore to the originator
     */
    @Override
    public void restore(Memento m) {
        if( m != null && InsertGhost.class.isInstance(m)){
            super.setReceiver(((InsertGhost)m).getReceiver());
            super.setTextinput(((InsertGhost) m).getTextState());
            super.setPosition(((InsertGhost) m).getPositionState());
        }
    }
}
