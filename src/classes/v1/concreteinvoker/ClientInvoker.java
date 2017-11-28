package classes.v1.concreteinvoker;


import classes.v1.concretecommands.*;
import classes.v1.concretereceiver.BoardReceiver;
import interfaces.v1.Receiver.Receiver;
import interfaces.v1.command.Command;
import interfaces.v1.invoker.Invoker;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClientInvoker extends Application implements Invoker {

    @FXML
    private Button copyButton;
    @FXML
    private Button cutButton;
    @FXML
    private Button pasteButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TextArea textarea;

    private Receiver engine;

    /*Prevent conflict between actions*/
    private enum ACTION {
        PASTE,
        DELETE,
        NONE
    }

    private ACTION currentAction = ACTION.NONE;

    @Override
    public void start(Stage stage){
        //application must include start
    }



    @FXML
    private void initialize() {
        this.textarea.requestFocus();
        this.engine = new BoardReceiver();
        //Detect any change on the textarea : insertion / deletion
        this.textarea.textProperty().addListener((observable, oldValue, newValue) -> {
            this.textarea.setOnKeyPressed(event -> {
                switch(event.getCode()){
                    case BACK_SPACE:
                        //Had to redefine it because the caretPosition move after pressing those keys
                        this.deleteAtPosition(this.textarea.getCaretPosition()-1);
                        break;
                    case DELETE:
                        this.deleteAtPosition(this.textarea.getCaretPosition());
                        break;
                }
            });
            if(oldValue.length() < newValue.length() && this.currentAction == ACTION.NONE){
                insertAtPosition(newValue, this.textarea.getCaretPosition());
            }
        });

        //Selection detection
        this.textarea.setOnMouseClicked(event -> {
            Selection selection = new Selection(this.textarea.getSelection().getStart(), this.textarea.getSelection().getEnd());
            selection.setReceiver(this.engine);
            this.setCommand(selection);
        });
    }

    /**
     * @param newValue The value to be inserted
     * @param position Position where to insert
    * Invoke the Insert command.
     */
    private void insertAtPosition(String newValue, int position){
        //Call insert command by taking the next character typed after the caret
        Insert insert = new Insert(Character.toString(newValue.charAt(position)), position);
        insert.setReceiver(this.engine);
        this.setCommand(insert);
    }


    /**
     * @param position Position of the character to delete
     * Invoke the delete command.
     */
    private void deleteAtPosition(int position){
        Delete del = new Delete(position);
        del.setReceiver(this.engine);
        this.setCommand(del);
    }


    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke the Copy command.
     */
    @FXML
    private void handleCopy(MouseEvent event) {
        Copy copy = new Copy();
        copy.setReceiver(this.engine);
        this.setCommand(copy);
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke the Cut command and mimic the same effect on the UI.
     */
    @FXML
    private void handleCut(MouseEvent event) throws CloneNotSupportedException {
        Cut cut = new Cut();
        cut.setReceiver(this.engine);
        this.setCommand(cut);
        this.textarea.setText(this.engine.getBufferClone().getText());
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke the Delete command and mimic the same effect on the UI.
     */
    @FXML
    private void handleDelete(MouseEvent event) throws CloneNotSupportedException {
        this.currentAction = ACTION.DELETE;
        this.textarea.requestFocus();
        int caretPosition = textarea.getCaretPosition();
        deleteAtPosition(caretPosition);
        this.textarea.setText(this.engine.getBufferClone().getText());
        //We have to position it manually or it will move to the beginning of the text
        this.textarea.positionCaret(caretPosition);
        this.currentAction = ACTION.NONE;
    }

    /**
     * @param event the paste (on click on the button)
     * Invoke the Cut command and mimic the same effect on the UI.
     */
    @FXML
    private void handlePaste(MouseEvent event) throws CloneNotSupportedException {
        this.currentAction = ACTION.PASTE;
        this.textarea.requestFocus();
        int caretPosition = this.textarea.getCaretPosition();
        int oldLength = this.textarea.getLength();
        Paste paste  = new Paste(caretPosition);
        paste.setReceiver(this.engine);
        this.setCommand(paste);
        this.textarea.setText(new StringBuilder(this.textarea.getText()).insert(caretPosition, this.engine.getClipboardClone().getClipboard()).toString());
        int newLength = this.textarea.getLength();
        //Position the caret at the end of the pasted words
        this.textarea.positionCaret(caretPosition+newLength-oldLength);
        this.currentAction = ACTION.NONE;
    }

    /**
     * @param command to execute
     */
    public void setCommand(Command command ) {
        command.execute();
    }

}