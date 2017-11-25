package classes.components;
/**
 * 
 */
public class ClipBoard implements Cloneable {

    /**
     *
     */
    private String clipboard;

    /**
     * Default constructor
     */
    public ClipBoard() {
        this.clipboard = "";
    }



    /**
     * @param text to store in the clipboard
     */
    public void setClipboard(String text) {
        // TODO implement here
        this.clipboard = text;
    }

    /**
     * @return text stored in clipboard
     */
    public String getClipboard() {
        return this.clipboard;
    }

    /**
     * @return true if clipboard is empty, false otherwise
     */
    public boolean isEmpty(){
        return this.getClipboard().isEmpty();
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}