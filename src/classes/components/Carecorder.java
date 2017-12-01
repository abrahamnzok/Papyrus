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
    private List<Pair<Memento,Recordable>> container;

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
    public void record(Memento memento, Recordable recordable) throws NoSuchMethodException {
        if(this.isRecording()) this.container.add(new Pair<>(memento, recordable));
    }

    /**
     * Sets the action of replaying on
     * At this point, we restore the mementos to their originators
     * replay cannot execute while recording
     */
    public void replay() {
        if(!this.isRecording()){
            this.container.forEach(
                    pair ->{
                        try {
                            pair.getValue().restore(pair.getKey());
                            System.out.println("Commande rejouée : " + pair.getValue().getClass().getSimpleName());
                        } catch (NoSuchMethodException e) {
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
    public void setrecording() {
        this.container.clear();
        this.recordingState = true;
        System.out.println("Recording ON !");
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
    public void stoprecording() {
        this.recordingState = false;
        System.out.println("Recording OFF !");
    }

    /**
     *
     */
    public List careclone() throws CloneNotSupportedException{
        return ((List) ((ArrayList<Pair<Memento,Recordable>>) this.container).clone());
    }
}
