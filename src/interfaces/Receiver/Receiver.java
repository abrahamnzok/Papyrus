package interfaces.Receiver;

import classes.components.Buffer;
import classes.components.ClipBoard;
import classes.components.Ranger;

/**
 *
 */
public interface Receiver {

    /**
     * @param text the text to insert
     * @param position the position where to insert the text
     */
    void insert(String text, int position);

    /**
     * @param start which the starting point of the selection
     * @param end which is the ending point of the selection
     */
    void select(int start, int end);

    /**
     * handles the action of copying the selection to the clipboard.
     */
    void copy();

    /**
     * handles the action of cutting the selection from the buffer and copying it to the clipboard
     */
    void cut();

    /**
     * @param position position where the content of the clipboard is to be put in the buffer
     */
    void paste(int position);

    /**
     * @param position of character to delete
    */
    void delete(int position);

    /**
     * @return a Buffer's clone.
     */
    Buffer getBufferClone() throws CloneNotSupportedException;

    /**
     * @return a Ranger's clone
     */
    Ranger getRangerClone() throws CloneNotSupportedException;

    /**
     * @return a Clipboard's clone
     */
    ClipBoard getClipboardClone() throws CloneNotSupportedException;


}
