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
     * Default constructor
     */
    public BoardReceiver() {

    }

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
     * @param text
     * @param position
     */
    @Override
    public void insert(String text, int position) {

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