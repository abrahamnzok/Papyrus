package classes.concreteinvoker;

import classes.concretecommands.*;
import interfaces.command.Command;
import interfaces.invoker.Invoker;
import interfaces.Receiver.Receiver;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Map;

public class ClientInvoker extends Application implements Invoker {

    @FXML
    private TextArea textarea;

    private Map<String, Command> commandMap;
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
                insertAtPosition(observable.getValue(), this.textarea.getCaretPosition());
            }
        });

        //Selection detection
        this.textarea.setOnMouseClicked(event -> {
            Selection selection = (Selection) this.commandMap.get("selection");
            selection.setStart(this.textarea.getSelection().getStart());
            selection.setEnd(this.textarea.getSelection().getEnd());
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
        Insert insert = (Insert) this.commandMap.get("insert");
        insert.setPosition(position);
        insert.setTextinput(Character.toString(newValue.charAt(position)));
        this.setCommand(insert);
    }


    /**
     * @param position Position of the character to delete
     * Invoke the delete command.
     */
    private void deleteAtPosition(int position){
        Delete del = (Delete) this.commandMap.get("delete");
        del.setPosition(position);
        this.setCommand(del);
    }


    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke the Copy command.
     */
    @FXML
    private void handleCopy(MouseEvent event){
        this.setCommand(this.commandMap.get("copy"));
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke the Cut command and mimic the same effect on the UI.
     */
    @FXML
    private void handleCut(MouseEvent event) throws CloneNotSupportedException {
        this.setCommand(this.commandMap.get("cut"));
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
        //Invoke the paste command
        Paste paste = (Paste) this.commandMap.get("paste");
        paste.setPaste(caretPosition);
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

    public void setCommandMap(Map<String, Command> m){
        this.commandMap = m;
    }

    public void setEngine(Receiver engine) {
        this.engine = engine;
    }
}