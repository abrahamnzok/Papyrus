package classes.recordablecommands;

import classes.concretecommands.Copy;
import classes.concretemementos.CopyGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class CopyRecordable extends Copy implements Recordable {

    public CopyRecordable(){
        super();
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
    public void restore(Memento m) {
        if( m != null && CopyGhost.class.isInstance(m)){
            super.setReceiver(((CopyGhost)m).getReceiver());
        }
    }
}
