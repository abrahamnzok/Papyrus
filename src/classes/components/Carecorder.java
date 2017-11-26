package classes.components;

import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carecorder implements Recorder,Cloneable {

    private List<Memento> mementoList;

    /*
     ** Preferred Constructor
     */

    public Carecorder(){
        this.mementoList = new ArrayList<>();
    }

    /**
     * @param memento to store
     */
    @Override
    public void record(Memento memento) {
        this.mementoList.add(memento);
    }

    /**
     *
     */
    @Override
    public void replay(Recordable recordable) {

    }

    /**
     *
     */
    @Override
    public void stop() {
    }

    /**
     *
     */
    public List careClone() throws CloneNotSupportedException{
        return ((List) ((ArrayList) this.mementoList).clone());
    }

}
