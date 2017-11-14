package Classes.Components;


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
     * @param spaceBegin  starting point of selection
     * @param spaceEnd  ending point of selection
     *
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

    public void setSelection(String selection){
        if(!this.isEmptyChar(selection) || this.getSpaceBegin() != this.getSpaceEnd()) {
            this.selection = this.filterEmptyChars(selection);
        }
    }

    protected boolean isEmptyChar(String empty) {
        return empty.equals(" ");
    }

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

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}