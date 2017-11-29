package classes.recordablecommands;

import classes.concretecommands.Cut;
import classes.concretemementos.CutGhost;
import interfaces.memento.Memento;
import interfaces.recordable.Recordable;

public class CutRecordable extends Cut implements Recordable {



    /**
     *
     */
    public CutRecordable(){
        super();
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
}
