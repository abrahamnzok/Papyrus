package classes.components;


public class Ranger implements Cloneable {

    /**
     * {@code int} to hold the value of the starting point
     */
    private int spaceBegin;

    /**
     * {@code int} to hold the content {@link Ranger} receives from {@link Buffer}
     */
    private String selection;

    /**
     * {@code int} to hold the value of the starting point
     */
    private int spaceEnd;

    /**
     * Default constructor
     */
    public Ranger() {
        this.selection = "";
    }

    /**
     * @param spaceBegin  starting point of selection
     * @param spaceEnd  ending point of selection
     * if {@param spaceBegin} is greater that {@param spaceEnd}
     * they will switch one {@param spaceBegin} will become another {@param spaceEnd} and vice versa.
     */
    public void range(int spaceBegin , int spaceEnd ) {
        if(spaceBegin > spaceEnd){
            this.spaceBegin = spaceEnd;
            this.spaceEnd = spaceBegin;
        }else{
            this.spaceBegin = spaceBegin;
            this.spaceEnd = spaceEnd;
        }
    }

    /**
     * @return starting point of selection
     */
    public int getSpaceBegin() {
        return this.spaceBegin;
    }

    /**
     * @return ending point of selection
     */
    public int getSpaceEnd() {
        return this.spaceEnd;
    }

    /**
     * @param selection the content from the buffer to be stored by {@param selection}
     */
    public void setSelection(String selection){
        if(!this.isEmptyChar(selection) || this.getSpaceBegin() != this.getSpaceEnd()) {
            this.selection = this.filterEmptyChars(selection);
        }
    }

    /**
     *
     * @param empty String to be analysed for the presence of empty characters
     * @return true if it does, false otherwise
     */
    protected boolean isEmptyChar(String empty) {
        return empty.equals(" ");
    }

    /**
     * @param selection to be trimmed
     * @return the same content without empty characters before and after the outline
     */

    protected String filterEmptyChars(String selection){
        return selection.trim();
    }

    /**
     * @return selection which the selected text
     */
    public String getSelection() {
        return this.selection;
    }

    /**
     * @return true if selection is empty an string
     */
    public boolean isEmpty() {
        return this.getSelection().isEmpty();
    }

    /**
     * Clears the content of the Ranger.
     */
    public void clear(){
        this.selection = "";
    }

    /**
     * @return a shallow copy of this
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}