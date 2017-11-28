package classes.components;

import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

import java.util.HashMap;
import java.util.Map;

public class Carecorder implements Recorder,Cloneable {

    private Map<Class,Memento> mementoMap;

    /*
     ** Preferred Constructor
     */

    public Carecorder(){
        this.mementoMap = new HashMap<>();
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
    public Map careClone() throws CloneNotSupportedException{
        return ((Map) ((HashMap) this.mementoMap).clone());
    }

}
