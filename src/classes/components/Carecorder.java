package classes.components;

import interfaces.memento.Memento;
import interfaces.recordable.Recordable;
import interfaces.recorder.Recorder;
import java.util.ArrayList;
import java.util.List;

/**
 * Immutable object also called caretaker.
 * It knows how, why and when to store and restore the originators
 * {@link classes.recordablecommands.CopyRecordable}, {@link classes.recordablecommands.CutRecordable}
 * {@link classes.recordablecommands.SelectionRecordable}, {@link classes.recordablecommands.PasteRecordable}
 * {@link classes.recordablecommands.DeleteRecordable}, {@link classes.recordablecommands.InsertRecordable}
 */
public class Carecorder implements Recorder,Cloneable {

    /**
     * Internal object inside which we store {@link Memento} objects
     * This object is never to be accessed from external objects
     */
    private List<Pair<Memento,Recordable>> container;

    /**
     * {@code boolean} controls whether the recording is on or not
     */
    private boolean recordingState;

    /**
     * Instanciate an internal object that will store the Memento
     * A list in this case {@link List}
     * A the creation of the caretaker the recording state must be off {@param recordingState}
     * Preferred Constructor
     */
    public Carecorder(){
        this.container = new ArrayList<>();
        this.recordingState = false;
    }

    /**
     * When storing mementos, the caretaker puts them in a immutable object {@link Pair}
     * The key of the pair is a Memento
     * The value of the pair is a Recordable
     * @param memento stored by the caretaker
     * @param recordable the originator associated with the memento
     * @throws NoSuchMethodException
     */
    @Override
    public void record(Memento memento, Recordable recordable) throws NoSuchMethodException {
        if(this.isRecording()) this.container.add(new Pair<>(memento, recordable));

    }

    /**
     * Sets On the action of replaying
     * At this point, we restore the mementos to their originators
     * replay cannot execute while recording
     */
    @Override
    public void replay() {
        if(!this.isRecording() && !this.container.isEmpty()){
            this.container.forEach(
                    pair ->{
                        try {
                            pair.getValue().restore(pair.getKey());
                            System.out.println("Replayed Command : " + pair.getValue().getClass().getSimpleName());
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
    @Override
    public void setrecording() {
        this.container.clear();
        this.recordingState = true;
        System.out.println("Recording ON !");
    }

    /**
     * @return boolean true if the recording state is on, false otherwise
     */
    private boolean isRecording() {
        return this.recordingState;
    }

    /**
     * Stops the action of recording by modifying to false the boolean
     * that controls the recording state.
     */
    @Override
    public void stoprecording() {
        this.recordingState = false;
        System.out.println("Recording OFF !");
    }

    /**
     * This object is mainly used for testing purposes.
     * @return a shallow copy of the object that contains the mementos
     * @throws CloneNotSupportedException
     */
    public List careclone() throws CloneNotSupportedException{
        return ((List) ((ArrayList<Pair<Memento,Recordable>>) this.container).clone());
    }
}
