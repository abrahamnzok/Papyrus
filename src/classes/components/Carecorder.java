package classes.components;

import interfaces.memento.Memento;
import interfaces.recorder.Recorder;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Carecorder implements Recorder,Cloneable {

    /**
     *
     */
    private List<Pair<Constructor,Memento>> container;

    /**
     *
     */
    private boolean recordingState;

    /**
     * Preferred Constructor
     */

    public Carecorder(){
        this.container = new ArrayList<>();
        this.recordingState = false;
    }

    /**
     * @param memento to store
     */
    @Override
    public void record(Memento memento) throws NoSuchMethodException {
        if(this.hasPermission()) {
            this.container.add(new Pair<>(memento.getClass().getConstructor(), memento));
        }
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
        this.container.clear();
        this.recordingState = true;
    }

    /**
     *
     */
    private boolean hasPermission() {
        return this.recordingState;
    }

    /**
     *
     */
    @Override
    public void stoprecording() {
        this.recordingState = false;
    }

    /**
     *
     */
    public List careclone() throws CloneNotSupportedException{
        return ((List) ((ArrayList<Pair<Constructor,Memento>>) this.container).clone());
    }
}
