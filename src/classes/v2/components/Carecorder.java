package classes.v2.components;

import interfaces.v1.command.Command;
import interfaces.v2.memento.Memento;
import interfaces.v2.recorder.Recorder;

import java.util.*;

public class Carecorder implements Recorder,Cloneable {

    private Map<Class, Memento> mementoMap;

    /*
     ** Preferred Constructor
     */

    public Carecorder(){
    }

    /**
     * @param command to store
     */
    @Override
    public void record(Command command) {
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
    public void stop() {
    }

    /**
     *
     */
    public Map careClone() throws CloneNotSupportedException{
        return (Map) ((HashMap)this.mementoMap).clone();
    }

}
