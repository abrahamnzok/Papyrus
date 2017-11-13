package Classes.ConcreteReceiver;

import Classes.Components.Buffer;
import Classes.Components.ClipBoard;
import Classes.Components.Ranger;
import Interfaces.Receiver.Receiver;
/**
 *
 */
public class BoardReceiver implements Receiver {
    /**
     *
     */
    private Buffer buffer;

    /**
     *
     */
    private ClipBoard clipboard;

    /**
     *
     */
    private Ranger ranger;


    /**
     * Default constructor
     */
    public BoardReceiver() {
        this.buffer = new Buffer();
        this.clipboard = new ClipBoard();
        this.ranger = new Ranger();
    }

    /**
     * @param buffer, clipboard, ranger
     */
    public BoardReceiver(Buffer buffer, ClipBoard clipboard, Ranger ranger) {
        this.buffer = buffer;
        this.clipboard = clipboard;
        this.ranger = ranger;
    }


    /**
     */
    @Override
    public void cut() {
    }

    /**
     */
    @Override
    public void paste() {
    }

    /**
     * Insert a text (string) in the buffer at the defined position
     * @param text The text to insert
     * @param position The position where to insert the text
     */
    @Override
    public void insert(String text, int position) {
        String currentText = this.buffer.getText();
        String newText = new StringBuilder(currentText).insert(position, text).toString();
        this.buffer.setText(newText);
    }

    /**
     */
    @Override
    public void copy() {

    }

    /**
     * @param position position of character to delete
     */
    @Override
    public void delete(int position) {
        if(!this.buffer.getText().isEmpty() && position < this.buffer.getText().length()){
            String newText = (new StringBuilder(this.buffer.getText()).deleteCharAt(position)).toString();
            this.buffer.setText(newText);
        }
    }

    /**
     * @param start which the starting point of the selection
     * @param end   which is the ending point of the selection
     */
    @Override
    public void select(int start, int end) {
        this.ranger.range(start, end);
        this.ranger.setSelection(
                this.buffer.getText().substring(
                        this.ranger.getSpaceBegin(),
                        this.ranger.getSpaceEnd()));
    }

    /**
     */
    @Override
    public Buffer getBufferClone() throws CloneNotSupportedException {
        return (Buffer) this.buffer.clone();
    }

    /**
     */
    @Override
    public Ranger getRangerClone() throws CloneNotSupportedException {
        return (Ranger) this.ranger.clone();
    }

    /**
     */
    @Override
    public ClipBoard getClipboardClone() throws CloneNotSupportedException {
        return (ClipBoard) this.clipboard.clone();
    }

}
