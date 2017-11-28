package classes.recordablecommands;

import classes.concretecommands.Cut;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class CutRecordable extends Cut implements Recordable {


    /**
     * @return Specific Memento for the specific Recordable
     */
    @Override
    public Memento save() {
        return null;
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {

    }
}
