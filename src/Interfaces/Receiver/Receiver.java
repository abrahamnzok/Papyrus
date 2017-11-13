package Interfaces.Receiver;

import Classes.Components.Buffer;
import Classes.Components.ClipBoard;
import Classes.Components.Selection;

import java.util.*;

/**
 * 
 */
public interface Receiver {



    /**
     */
    public void cut();

    /**
     */
    public void paste();


    /**
     * @param text
     * @param position
     */
    public void insert(String text, int position);

    /**
     */
    public void copy();

    /**
    */
    public void delete(String text, int position);

    /**
     */
    public Buffer getBufferClone() throws CloneNotSupportedException;

    /**
     */
    public Selection getSelectionClone() throws CloneNotSupportedException;

    /**
     */
    public ClipBoard getClipboardClone() throws CloneNotSupportedException;


}