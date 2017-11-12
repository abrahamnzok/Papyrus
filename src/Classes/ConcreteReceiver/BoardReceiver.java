package Classes.ConcreteReceiver;

import Classes.Components.Buffer;
import Classes.Components.ClipBoard;
import Classes.Components.Selection;
import Interfaces.Receiver.Receiver;

import java.util.*;

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
        System.out.println(this.buffer.getText());
    }

    /**
     */
    @Override
    public void copy() {

    }

    /**
     */
    @Override
    public void delete() {

    }
}