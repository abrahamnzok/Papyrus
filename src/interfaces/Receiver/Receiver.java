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
    void insert(String text, int position);

    /**
     * @param start which the starting point of the selection
     * @param end which is the ending point of the selection
     */
    void select(int start, int end);

    /**
     */
    void copy();

    /**
     */
    void cut();

    /**
     */
    void paste(int position);

    /**
     * @param position of character to delete
    */
    void delete(int position);

    /**
     */
    Buffer getBufferClone() throws CloneNotSupportedException;

    /**
     */
    Ranger getRangerClone() throws CloneNotSupportedException;

    /**
     */
    ClipBoard getClipboardClone() throws CloneNotSupportedException;


}
