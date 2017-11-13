package Classes.Components;

import java.util.*;

/**
 * 
 */
public class Selection {
    /**
     *
     */
    private int spaceBegin;

    /**
     *
     */
    private String selection;

    /**
     *
     */
    private int spaceEnd;

    /**
     * Default constructor
     */
    public Selection() {
    }

    /**
     * @param spaceBegin  
     * @param spaceEnd  
     *
     */
    public void makeSelection(int spaceBegin , int spaceEnd ) {
        // TODO implement here
        this.spaceBegin = spaceBegin;
        this.spaceEnd = spaceEnd;
    }

    /**
     * @return
     */
    public int getSpaceBegin() {
        // TODO implement here
        return this.spaceBegin;
    }

    public int getSpaceEnd() {
        // TODO implement here
        return this.spaceEnd;
    }

    /**
     * @param selection
     */

    public void setSelection(String selection){
        this.selection = selection;
    }
    /**
     * @return
     */
    public String getSelection() {
        // TODO implement here
        return this.selection;
    }

}