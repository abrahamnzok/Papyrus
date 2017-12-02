package classes.concretereceiver;

import classes.components.Buffer;
import classes.components.ClipBoard;
import classes.components.Ranger;
import interfaces.Receiver.Receiver;

/**
 * Object of type Receiver
 * Handles all the actions executed by the concrete commands
 * {@link classes.concretecommands.Insert} {@link classes.concretecommands.Selection}
 * {@link classes.concretecommands.Paste} {@link classes.concretecommands.Delete}
 * {@link classes.concretecommands.Cut} {@link classes.concretecommands.Copy}
 */
public class BoardReceiver implements Receiver {

    /**
     * Object that stores the user's input
     * When there is an insert, paste or delete action
     */
    private Buffer buffer;

    /**
     * Object that stores temporary content of the buffer
     * When there is a copy or cut action
     */
    private ClipBoard clipboard;

    /**
     * Object that deals with the selection
     * When there is a select action
     */
    private Ranger ranger;


    /**
     * Preferred constructor of the engine
     * Internal objects include {@link Buffer} {@link ClipBoard} {@link Ranger}
     */
    public BoardReceiver() {
        this.buffer = new Buffer();
        this.clipboard = new ClipBoard();
        this.ranger = new Ranger();
    }

    /**
     * Auxiliary Constructor
     * @param buffer, clipboard, ranger
     */
    public BoardReceiver(Buffer buffer, ClipBoard clipboard, Ranger ranger) {
        this.buffer = buffer;
        this.clipboard = clipboard;
        this.ranger = ranger;
    }

    /**
     * inserts a text {@link String} in the buffer at a position
     * @param text the text to insert
     * @param position the position where to insert the text
     * {@param position} can never be out of boundaries
     */
    @Override
    public void insert(String text, int position) {
        if(position <= this.buffer.length() && position >= 0) {
            String currentText = this.buffer.getText();
            String newText = new StringBuilder(currentText).insert(position, text).toString();
            this.buffer.setText(newText);
        }
    }

    /**
     * @param start which the starting point of the selection
     * @param end which is the ending point of the selection
     * if the selection is set out of boundaries then selection is made on the whole content
     */
    @Override
    public void select(int start, int end) {
        this.ranger.range(start, end);
        if(this.ranger.getSpaceEnd() >= this.buffer.length()){
            this.ranger.range(this.ranger.getSpaceBegin(), this.buffer.length());
            if(this.ranger.getSpaceBegin() >= this.buffer.length()){
                this.ranger.range(0, this.buffer.length());
            }
        }
        this.ranger.setSelection(this.buffer.getText().substring(this.ranger.getSpaceBegin(), this.ranger.getSpaceEnd()));
    }

    /**
     * handles the action of copying the selection to the clipboard.
     * We can only perform this action on the assurance that the ranger is not empty
     *
     */
    @Override
    public void copy() {
        if(!this.ranger.getSelection().isEmpty())this.clipboard.setClipboard(this.ranger.getSelection());
    }

    /**
     * handles the action of cutting the selection from the buffer and copying it to the clipboard
     * We can only perform a cut action on the assurance that the ranger is not empty
     */
    @Override
    public void cut() {
        if(!this.ranger.isEmpty()) {
            this.copy();
            this.clear(this.ranger.getSpaceBegin(), this.ranger.getSpaceEnd());
        }
    }

    /**
     * @param position position where the content of the clipboard is to be put in the buffer
     * position can never be set out of boundaries
     */
    @Override
    public void paste(int position) {
        if(!this.clipboard.isEmpty()) {
            this.insert(this.clipboard.getClipboard(), position);
        }
    }

    /**
     * @param position position of the character to delete
     * position can never be set out of boundaries
     */
    @Override
    public void delete(int position) {
        if(!this.buffer.isEmpty() && position < this.buffer.length() && position >= 0){
            String newText = (new StringBuilder(this.buffer.getText()).deleteCharAt(position)).toString();
            this.buffer.setText(newText);
        }
    }

    /**
     * @param start starting point of deletion
     * @param end end point of deletion
     */
    private void clear(int start, int end) {
        if(!this.buffer.isEmpty() && start <= this.buffer.length() && end <= this.buffer.length()){
            String newText = (new StringBuilder(this.buffer.getText()).delete(start, end)).toString();
            this.buffer.setText(newText);
        }
    }

    /**
     * @return a Buffer's clone.
     * A clone of object Buffer is rendered to avoid the real object being modified
     */
    @Override
    public Buffer getBufferClone() throws CloneNotSupportedException {
        return (Buffer) this.buffer.clone();
    }

    /**
     * @return a Ranger's clone
     *  A clone of the object is rendered to avoid the real object being modified
     */
    @Override
    public Ranger getRangerClone() throws CloneNotSupportedException {
        return (Ranger) this.ranger.clone();
    }

    /**
     * @return a Clipboard's clone
     * A clone of the object is rendered to avoid the real object being modified
     */
    @Override
    public ClipBoard getClipboardClone() throws CloneNotSupportedException {
        return (ClipBoard) this.clipboard.clone();
    }

}
