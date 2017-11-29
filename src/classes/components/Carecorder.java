package classes.components;

import interfaces.memento.Memento;
import interfaces.recorder.Recorder;

import java.util.ArrayList;
import java.util.List;

public class Carecorder implements Recorder,Cloneable {

    private List<Pair<Class,Memento>> container;

    /*
     ** Preferred Constructor
     */

    public Carecorder(){
        this.container = new ArrayList<>();
    }

    /**
     * @param memento to store
     */
    @Override
    public void record(Memento memento) {

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
        return ((List) ((ArrayList<Pair<Class,Memento>>) this.container).clone());
    }

}
