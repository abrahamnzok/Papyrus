package classes.components;

import interfaces.memento.Memento;
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
    public void replay() {

    }

    /**
     *
     */
    @Override
    public void setRecording(boolean record) {
    }

    /**
     *
     */
    @Override
    public boolean isRecording() {
        return false;
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
    public Map careclone() throws CloneNotSupportedException{
        return ((Map) ((HashMap) this.mementoMap).clone());
    }

}
