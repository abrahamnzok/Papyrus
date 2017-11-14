package Classes.Components;
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

    /**
     * @return
     */
    public boolean isEmpty(){
        return this.getClipboard().isEmpty();
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}