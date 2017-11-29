package classes.components;

import interfaces.memento.Memento;
import interfaces.recorder.Recorder;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Carecorder implements Recorder,Cloneable {

    private List<Pair<Constructor,Memento>> container;

    /**
     * Preferred Constructor
     */

    public Carecorder(){
        this.container = new ArrayList<>();
    }

    /**
     * @param memento to store
     */
    @Override
    public void record(Memento memento) throws NoSuchMethodException {
        this.container.add(new Pair<>(memento.getClass().getConstructor(), memento));
    }

    /**
     *
     */
    @Override
    public void replay() {

    }

    /**
     *
     */
    @Override
    public void setrecording() {
    }

    /**
     *
     */
    @Override
    public boolean isrecording() {
        return false;
    }

    /**
     *
     */
    @Override
    public void stoprecording() {

    }

    /**
     *
     */
    public List careclone() throws CloneNotSupportedException{
        return ((List) ((ArrayList<Pair<Constructor,Memento>>) this.container).clone());
    }

}
