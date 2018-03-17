package classes.concretemementos;

import classes.components.Buffer;
import classes.components.ClipBoard;
import classes.components.Ranger;
import interfaces.memento.Memento;

/**
 * Immutable Object {@link Memento} of the recordable {@link classes.concretereceiver.BoardReceiver}
 */
public class BoardGhost implements Memento {

  /**
   * Object {@link Buffer} state
   */
  private Buffer bufferState;
  /**
   * Object {@link Ranger} state
   */
  private Ranger rangerState;
  /**
   * Object {@link ClipBoard} state
   */
  private ClipBoard clipBoardState;

  /**
   * @param bufferState {@link Buffer}
   * @param rangerState {@link Ranger}
   * @param clipBoard {@link ClipBoard}
   */
  public BoardGhost(Buffer bufferState, Ranger rangerState, ClipBoard clipBoard) {
    this.bufferState = bufferState;
    this.rangerState = rangerState;
    this.clipBoardState = clipBoard;
  }

  /**
   * @return {@link Buffer} state
   */
  public Buffer getBufferState() {
    return this.bufferState;
  }

  /**
   * @return {@link Ranger} state
   */
  public Ranger getRangerState() {
    return this.rangerState;
  }

  /**
   * @return {@link ClipBoard} state
   */
  public ClipBoard getClipBoardState() {
    return this.clipBoardState;
  }

}
