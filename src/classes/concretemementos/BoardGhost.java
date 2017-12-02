package classes.concretemementos;

import classes.components.Buffer;
import classes.components.ClipBoard;
import classes.components.Ranger;
import interfaces.memento.Memento;

public class BoardGhost implements Memento {
    private Buffer bufferState;
    private Ranger rangerState;
    private ClipBoard clipBoardState;

    public BoardGhost(Buffer bufferState, Ranger rangerState, ClipBoard clipBoard) {
        this.bufferState = bufferState;
        this.rangerState = rangerState;
        this.clipBoardState = clipBoard;
    }

    public Buffer getBufferState() {
        return bufferState;
    }

    public void setBufferState(Buffer bufferState) {
        this.bufferState = bufferState;
    }

    public Ranger getRangerState() {
        return rangerState;
    }

    public void setRangerState(Ranger rangerState) {
        this.rangerState = rangerState;
    }

    public ClipBoard getClipBoardState() {
        return clipBoardState;
    }

    public void setClipBoardState(ClipBoard clipBoardState) {
        this.clipBoardState = clipBoardState;
    }
}
