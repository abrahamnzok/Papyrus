package Classes.Components;

import java.util.*;

/**
 * 
 */
public class Ranger {
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
    public Ranger() {
        this.selection = "";
    }

    /**
     * @param spaceBegin  
     * @param spaceEnd  
     *
     */
    public void range(int spaceBegin , int spaceEnd ) {
        // TODO implement here
        if(spaceBegin > spaceEnd){
            this.spaceBegin = spaceEnd;
            this.spaceEnd = spaceBegin;
        }else{
            this.spaceBegin = spaceBegin;
            this.spaceEnd = spaceEnd;
        }
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

    public void setSelection(String selection){
        if(!this.isEmptyChar(selection)) {
            this.selection = selection;
        }
    }

    protected boolean isEmptyChar(String empty) {
        return empty.contains(" ");
    }

    protected void filterEmptyChars(String selection){
    }

    /**
     * @return
     */
    public String getSelection() {
        // TODO implement here
        return this.selection;
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}