package classes.recordablecommands;

import classes.concretecommands.Paste;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class PasteRecordable extends Paste implements Recordable {


    /**
     * Default constructor
     */
    public PasteRecordable() {
        super();
    }

    public PasteRecordable(int position) {
        super(position);
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
