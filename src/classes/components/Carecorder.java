package classes.components;

import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Carecorder implements Recorder,Cloneable {

    /**
     *
     */
    private List<Pair<Class,Memento>> container;

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
    public void record(Class myclass, Memento memento) throws NoSuchMethodException {
        if(this.isRecording()) this.container.add(new Pair<>(myclass, memento));
    }

    /**
     * Sets the action of replaying on
     * At this point, we restore the mementos to their originators
     * replay cannot execute while recording
     */
    @Override
    public void replay() {
        if(!this.isRecording()){
            this.container.forEach(
                    pair ->{
                        Constructor o = null;
                        try {
                            o = ((Class<?>)pair.getKey()).getConstructor();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        try {
                            assert o != null;
                            Recordable r = (Recordable) o.newInstance();
                            r.restore(pair.getValue());
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
    }

    /**
     * Sets the action of recording on
     * The container of mementos must be cleared each time a recording session starts
     * Otherwise we would play past recordings
     */
    @Override
    public void setrecording() {
        this.container.clear();
        this.recordingState = true;
    }

    /**
     *
     */
    private boolean isRecording() {
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
        return ((List) ((ArrayList<Pair<Class,Memento>>) this.container).clone());
    }
}
