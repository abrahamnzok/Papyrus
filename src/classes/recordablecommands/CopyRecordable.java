package classes.recordablecommands;

import classes.concretecommands.Copy;
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
        return null;
    }

    /**
     * @param m to restore
     */
    @Override
    public void restore(Memento m) {

    }
}
