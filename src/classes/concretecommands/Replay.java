package classes.concretecommands;

import classes.components.Carecorder;
import interfaces.command.Command;
import interfaces.recorder.Recorder;

public class Replay implements Command {

  /**
   * {@link Recorder} that takes care of the recording and replaying tasks
   */
  private Recorder recorder;

  /**
   * executes the action to be performed by the receiver
   */
  @Override
  public void execute() {
    ((Carecorder) this.recorder).replay();
  }

  /**
   * @param recorder is the receiver to perform the replay
   */
  public void setReceiver(Recorder recorder) {
    this.recorder = recorder;
  }
}
