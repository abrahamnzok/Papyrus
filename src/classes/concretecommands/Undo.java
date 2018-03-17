package classes.concretecommands;

import classes.components.DoUndoEngine;
import interfaces.command.Command;
import interfaces.recorder.Recorder;

public class Undo implements Command {

  private Recorder recorder;

  /**
   * Calls the engine's method goForward)
   */
  @Override
  public void execute() throws NoSuchMethodException {
    ((DoUndoEngine) this.recorder).goBackward();
  }

  /**
   * @param recorder is the receiver to perform the recording
   */
  public void setReceiver(Recorder recorder) {
    this.recorder = recorder;
  }
}
