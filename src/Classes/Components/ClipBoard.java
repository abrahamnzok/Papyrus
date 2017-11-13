package Classes.Components;
/**
 * 
 */
public class ClipBoard implements Cloneable {

    /**
     * Default constructor
     */
    public ClipBoard() {
    }

    /**
     * 
     */
    private String clipboard;



    /**
     * @param text 
     */
    public void setClipboard(String text) {
        // TODO implement here
        this.clipboard = text;
    }

    /**
     * @return
     */
    public String getClipboard() {
        // TODO implement here
        return this.clipboard;
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}