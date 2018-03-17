package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * Immutable {@link Memento} of the recordable command {@link classes.recordablecommands.InsertRecordable}
 */
public class InsertGhost implements Memento {

  /**
   * {@code String} to hold state of the input
   */
  private String inputState;

  /**
   * {@code int} to hold state of the position
   */
  private int positionState;

  /**
   * {@link Receiver} to hold the state of the receiver
   */
  private Receiver receiverState;

  /**
   * @param receiverState {@link Receiver} state
   * @param inputState input state
   * @param positionState position state
   */
  public InsertGhost(Receiver receiverState, String inputState, int positionState) {
    this.receiverState = receiverState;
    this.inputState = inputState;
    this.positionState = positionState;
  }

  /**
   * @return position' state
   */
  public int getPositionState() {
    return this.positionState;
  }

  /**
   * @return input' state
   */
  public String getInputState() {
    return this.inputState;
  }

  /**
   * @return receiver' state
   */

  public Receiver getReceiver() {
    return this.receiverState;
  }


}