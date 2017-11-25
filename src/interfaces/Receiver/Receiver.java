package interfaces.Receiver;

import classes.components.Buffer;
import classes.components.ClipBoard;
import classes.components.Ranger;

/**
 *
 */
public interface Receiver {

    /**
     * @param text
     * @param position
     */
    public void insert(String text, int position);

    /**
     * @param start which the starting point of the selection
     * @param end which is the ending point of the selection
     */
    public void select(int start, int end);

    /**
     */
    public void copy();

    /**
     */
    public void cut();

    /**
     */
    public void paste(int position);

    /**
     * @param position of character to delete
    */
    public void delete(int position);

    /**
     */
    public Buffer getBufferClone() throws CloneNotSupportedException;

    /**
     */
    public Ranger getRangerClone() throws CloneNotSupportedException;

    /**
     */
    public ClipBoard getClipboardClone() throws CloneNotSupportedException;


}
