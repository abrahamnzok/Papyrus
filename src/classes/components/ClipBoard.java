package classes.components;

/**
 * Object that deals with the storage of temporary content from the Buffer .
 */
public class ClipBoard implements Cloneable {

    /**
     * Internal object where a content is stored.
     */
    private String clipboard;

    /**
     * Default constructor .
     */
    public ClipBoard() {
        this.clipboard = "";
    }



    /**
     * @param text to store in the clipboard .
     */
    public void setClipboard(String text) {
        // TODO implement here
        this.clipboard = text;
    }

    /**
     * @return text stored in clipboard .
     */
    public String getClipboard() {
        return this.clipboard;
    }

    /**
     * @return true if clipboard is empty, false otherwise .
     */
    public boolean isEmpty(){
        return this.getClipboard().isEmpty();
    }

    /**
     *
     * @return a shallow copy of {@link ClipBoard} .
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}