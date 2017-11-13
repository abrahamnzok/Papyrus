package Classes.ConcreteReceiver;

import Classes.Components.Buffer;
import Classes.Components.ClipBoard;
import Classes.Components.Selection;
import Interfaces.Receiver.Receiver;

import java.awt.datatransfer.Clipboard;

/**
 * 
 */
public class BoardReceiver implements Receiver {
    /**
     * 
     */
    private Buffer buffer;

    /**
     * 
     */
    private ClipBoard clipboard;

    /**
     * 
     */
    private Selection selector;


    /**
     * Default constructor
     */
    public BoardReceiver() {
        this.buffer = new Buffer();
        this.clipboard = new ClipBoard();
        this.selector = new Selection();
    }

    /**
     * @param buffer, clipboard, selection
     */
    public BoardReceiver(Buffer buffer, ClipBoard clipboard, Selection selection) {
        this.buffer = buffer;
        this.clipboard = clipboard;
        this.selector = selection;
    }


    /**
     */
    @Override
    public void cut() {
    }

    /**
     */
    @Override
    public void paste() {
    }

    /**
     * Insert a text (string) in the buffer at the defined position
     * @param text The text to insert
     * @param position The position where to insert the text
     */
    @Override
    public void insert(String text, int position) {
        String currentText = this.buffer.getText();
        String newText = new StringBuilder(currentText).insert(position, text).toString();
        this.buffer.setText(newText);
    }

    /**
     */
    @Override
    public void copy() {

    }

    /**
     * @param text The text to delete or character to delete
     * @param position position of the text or character to delete
     */
    @Override
    public void delete(String text, int position) {
    }

    /**
     */
    @Override
    public Buffer getBufferClone() throws CloneNotSupportedException {
        return (Buffer) this.buffer.clone();
    }

    /**
     */
    @Override
    public Selection getSelectionClone() throws CloneNotSupportedException {
        return (Selection) this.selector.clone();
    }

    /**
     */
    @Override
    public ClipBoard getClipboardClone() throws CloneNotSupportedException {
        return (ClipBoard) this.clipboard.clone();
    }

}