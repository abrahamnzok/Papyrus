package Classes.Components;

import java.util.*;

/**
 * 
 */
public class Buffer implements Cloneable {

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

    /**
     *
     */
    public boolean isEmpty() {
        // TODO implement here
        return this.getText().isEmpty();
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


}