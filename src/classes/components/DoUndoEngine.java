package classes.components;

import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import interfaces.recorder.Recorder;
import java.util.Stack;


/**
 * Immutable object also called caretaker. It knows how, why and when to store and restore this
 * originator {@link BoardReceiver}
 */
public class DoUndoEngine implements Recorder, Cloneable {

  /**
   * Object {@link Stack}
   */
  private Stack<Memento> forward;
  /**
   * Object {@link Stack}
   */
  private Stack<Memento> backward;
  /**
   * Object {@link Receiver}
   */
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
   * Record the memento in the backward stack and empty the forward stack for new changes. It
   * empties the forward stack when a new Command is called
   *
   * @param memento to store
   */
  public void record(Memento memento) throws NoSuchMethodException, CloneNotSupportedException {
    this.backward.push(memento);
    this.forward.clear();
  }

  /**
   * Go forward in the action history
   */
  public void goForward() throws NoSuchMethodException {
    if (forward.size() > 0) {
      Memento b = this.forward.pop();
      this.backward.push(b);
      ((BoardReceiver) this.boardReceiver).restore(b);
    }
  }

  /**
   * Go backward in the action history
   */
  public void goBackward() throws NoSuchMethodException {
    if (backward.size() > 0) {
      Memento b = this.backward.pop();
      this.forward.push(b);
      ((BoardReceiver) this.boardReceiver).restore(b);
    }
  }

  /**
   *
   * @return
   * @throws CloneNotSupportedException
   */
  public Stack getForwardClone() throws CloneNotSupportedException {
    return (Stack) this.forward.clone();
  }

  /**
   *
   * @return
   * @throws CloneNotSupportedException
   */
  public Stack getBackwardClone() throws CloneNotSupportedException {
    return (Stack) this.backward.clone();
  }
}
