package classes.components;

/**
 * Buffer object
 * Its main use is to keep track of the changes made by the commands
 * Inside a String {@param text} that holds the text
 * 
 */
public class Buffer implements Cloneable {

    /**
     * Default constructor
     * Internal object is an empty {@link String}
     */
    public Buffer() {
        this.text = "";
    }

    /**
     * Object inside which the user's input is stored
     */
    private String text;

    /**
     * @param text the user's input
     * Which we then store inside our immutable object {@link String} {@param text}
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the content of the buffer if not empty
     */
    public String getText() {
        // TODO implement here
        return this.text;
    }

    /**
     * @return the length of the buffer. If the buffer is empty, 0 will be returned.
     */
    public int length() {
        // TODO implement here
        return this.getText().length();
    }

    /**
     * @return true if the buffer is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement here
        return this.getText().isEmpty();
    }

    /**
     * @return a shallow copy of this {@link Buffer}
     */
    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


}