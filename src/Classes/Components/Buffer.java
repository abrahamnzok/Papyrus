package Classes.Components;

import java.util.*;

/**
 * 
 */
public class Buffer {

    /**
     * 
     */
    private String text;

    /**
     * Default constructor
     */
    public Buffer() {
        this.text = "";
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     */
    public String getText() {
        // TODO implement here
        return this.text;
    }


}