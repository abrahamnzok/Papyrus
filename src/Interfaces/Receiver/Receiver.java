package Interfaces.Receiver;

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
    *
    */
    public void delete();


}