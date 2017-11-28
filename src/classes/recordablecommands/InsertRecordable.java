package classes.recordablecommands;

import classes.concretecommands.Insert;
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
        return null;
    }

    /**
     * @param m
     */
    @Override
    public void restore(Memento m) {

    }
}
