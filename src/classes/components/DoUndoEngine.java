package classes.components;

import classes.concretemementos.BoardGhost;
import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recorder.Recorder;

import java.util.Stack;

public class DoUndoEngine implements Recorder, Cloneable{

    private Stack<BoardGhost> forward;
    private Stack<BoardGhost> backward;
    private Receiver boardReceiver;


    /**
     * @param boardReceiver the receiver of the memento engine
     */
    public DoUndoEngine(Receiver boardReceiver) {
        this.boardReceiver = boardReceiver;
        this.forward = new Stack<>();
        this.backward = new Stack<>();
    }

    /**
     * Record the memento in the backward stack and empty the forward stack for new changes.
     * @param memento to store
     */
    public void record(Memento memento) throws NoSuchMethodException, CloneNotSupportedException {
        this.backward.push((BoardGhost) memento);
        //Empty the forward stack when a new Command is called
        this.forward.clear();
    }

    /**
     * Go forward in the action history
     */
    public void goForward() throws NoSuchMethodException {
        if(forward.size() > 0){
            Memento b = this.forward.pop();
            this.backward.push((BoardGhost) b);
            ((BoardReceiver) boardReceiver).restore(b);
        }
    }

    /**
     * Go backward in the action history
     */
    public void goBackward() throws NoSuchMethodException {
        if(backward.size() > 0){
            Memento b = this.backward.pop();
            this.forward.push((BoardGhost) b);
            ((BoardReceiver) boardReceiver).restore(b);
        }
    }

    /**
     * @param boardReceiver the receiver to set
     */
    public void setBoardReceiver(Receiver boardReceiver) {
        this.boardReceiver = boardReceiver;
    }

    public Stack getForwardClone() {
        return (Stack) forward.clone();
    }

    public Stack getBackwardClone() {
        return (Stack) backward.clone();
    }
}
