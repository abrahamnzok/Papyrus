package classes.concretecommands;

import classes.components.DoUndoEngine;
import interfaces.command.Command;
import interfaces.recorder.Recorder;

public class Redo implements Command {

  /**
   *
   */
  private Recorder recorder;

  /**
   * Calls the engine's method goBackward()
   */
  @Override
  public void execute() throws NoSuchMethodException {
    ((DoUndoEngine) this.recorder).goForward();
  }

  /**
   * @param recorder is the receiver to perform the recording
   */
  public void setReceiver(Recorder recorder) {
    this.recorder = recorder;
  }
}
