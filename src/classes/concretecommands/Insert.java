package classes.concretecommands;

import interfaces.command.Command;
import interfaces.Receiver.Receiver;

/**
 * Insert Command
 */
public class Insert implements Command {

  /**
   * {@link Receiver} to perform the action when the command is to be executed
   */
  private Receiver receiver;

  /**
   * {@code String} input
   */
  private String textinput;
  /**
   * {@code int} position where to insert
   */
  private int position;

  /**
   * Default constructor
   */
  public Insert() {
    this.textinput = "";
    this.position = 0;
  }

  /**
   * @param textToInsert input to insert inside the buffer
   * @param position where to insert
   */
  public Insert(String textToInsert, int position) {
    this.setPosition(position);
    this.textinput = textToInsert;
    this.position = this.getPosition();
  }

  /**
   * executes the action to be performed by the receiver
   */
  public void execute() throws NoSuchMethodException {
    this.receiver.insert(this.textinput, this.position);
  }

  /**
   * Sets the {@link Receiver}
   *
   * @param r Receiver which will execute the task
   */
  public void setReceiver(Receiver r) {
    this.receiver = r;
  }

  /**
   * @return textinput
   */
  public String getTextinput() {
    return this.textinput;
  }

  /**
   * @param textinput text that we need to insert
   */
  public void setTextinput(String textinput) {
    this.textinput = textinput;
  }

  /**
   * @return the position where to insert
   */
  public int getPosition() {
    return this.position;
  }

  /**
   * sets the position where the input is to be inserted
   *
   * @param position where to insert a text
   */
  public void setPosition(int position) {
    if (!this.isNegative()) {
      this.position = position;
    }
  }

  /**
   * @return boolean true if position is negative, false otherwise
   */
  public boolean isNegative() {
    return this.position < 0;
  }

  /**
   * @return receiver
   */
  public Receiver getReceiver() {
    return this.receiver;
  }

}