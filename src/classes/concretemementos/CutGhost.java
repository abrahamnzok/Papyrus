package classes.concretemementos;

import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;

/**
 * Immutable {@link Memento} of the recordable command {@link classes.recordablecommands.CutRecordable}
 */
public class CutGhost implements Memento {

  /**
   * {@link Receiver} state
   */
  private Receiver receiver;

  /**
   * @param receiver {@link Receiver} state
   */
  public CutGhost(Receiver receiver) {
    this.receiver = receiver;
  }

  /**
   * @return the state of the receiver
   */
  public Receiver getReceiver() {
    return this.receiver;
  }

}