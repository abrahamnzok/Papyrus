package classes.concreteinvoker;

import classes.concretecommands.*;
import interfaces.command.Command;
import interfaces.invoker.Invoker;
import interfaces.Receiver.Receiver;
import javafx.application.Application;
import javafx.event.ActionEvent;
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

    /** Prevent conflict between actions */
    private enum ACTION {
        PASTE,
        DELETE,
        REPLAY,
        NONE
    }

    private ACTION currentAction = ACTION.NONE;

    /**
     * Automatically called after creating the controller
     */
    @FXML
    private void initialize() {
        this.textarea.requestFocus();

        //Detect any change on the textarea : insertion / deletion
        this.textarea.textProperty().addListener((observable, oldValue, newValue) -> {
            this.textarea.setOnKeyPressed(event -> {
                switch(event.getCode()){
                    case BACK_SPACE:
                        try {
                            //Had to redefine the carret because it moves after pressing those keys
                            this.deleteAtPosition(this.textarea.getCaretPosition()-1);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        break;
                    case DELETE:
                        try {
                            this.deleteAtPosition(this.textarea.getCaretPosition());
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            });
            if(oldValue.length() < newValue.length() && this.currentAction == ACTION.NONE){
                try {
                    insertAtPosition(observable.getValue(), this.textarea.getCaretPosition());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        });

        //Selection detection
        this.textarea.setOnMouseClicked(event -> {
            Selection selection = (Selection) this.commandMap.get("selection");
            selection.setStart(this.textarea.getSelection().getStart());
            selection.setEnd(this.textarea.getSelection().getEnd());
            try {
                this.setCommand(selection);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @param newValue The value to be inserted
     * @param position Position where to insert
     * Invoke the Insert command.
     */
    private void insertAtPosition(String newValue, int position) throws NoSuchMethodException {
        //Call insert command by taking the next character typed after the caret
        Insert insert = (Insert) this.commandMap.get("insert");
        insert.setPosition(position);
        insert.setTextinput(Character.toString(newValue.charAt(position)));
        this.setCommand(insert);
    }


    /**
     * @param position Position of the character to delete
     * Invoke the delete command.
     * @throws NoSuchMethodException
     */
    private void deleteAtPosition(int position) throws NoSuchMethodException {
        Delete del = (Delete) this.commandMap.get("delete");
        del.setPosition(position);
        this.setCommand(del);
    }


    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke the Undo command
     * @throws NoSuchMethodException
     */
    @FXML
    private void handleUndo(MouseEvent event) throws NoSuchMethodException {
        this.setCommand(this.commandMap.get("copy"));
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke the Redo command.
     * @throws NoSuchMethodException
     */
    @FXML
    private void handleRedo(MouseEvent event) throws NoSuchMethodException {
        this.setCommand(this.commandMap.get("copy"));
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke {@link Copy} command.
     * @throws NoSuchMethodException
     */
    @FXML
    private void handleCopy(MouseEvent event) throws NoSuchMethodException {
        this.setCommand(this.commandMap.get("copy"));
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke {@link Cut} command and mimic the same effect on the UI.
     * @throws CloneNotSupportedException
     * @throws NoSuchMethodException
     */
    @FXML
    private void handleCut(MouseEvent event) throws CloneNotSupportedException, NoSuchMethodException {
        this.setCommand(this.commandMap.get("cut"));
        this.textarea.setText(this.engine.getBufferClone().getText());
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke {@link Delete} command and mimic the same effect on the UI.
     * @throws CloneNotSupportedException
     * @throws NoSuchMethodException
     */
    @FXML
    private void handleDelete(MouseEvent event) throws CloneNotSupportedException, NoSuchMethodException {
        this.currentAction = ACTION.DELETE;
        this.textarea.requestFocus();
        int caretPosition = textarea.getCaretPosition();
        this.deleteAtPosition(caretPosition);
        this.textarea.setText(this.engine.getBufferClone().getText());
        //We have to position it manually or it will move to the beginning of the text
        this.textarea.positionCaret(caretPosition);
        this.currentAction = ACTION.NONE;
    }

    /**
     * @param event the MouseEvent (on click on the button)
     * Invoke {@link Paste} command and mimic the same effect on the UI.
     * @throws CloneNotSupportedException
     * @throws NoSuchMethodException
     */
    @FXML
    private void handlePaste(MouseEvent event) throws CloneNotSupportedException, NoSuchMethodException {
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
     * @param event the ActionEvent (on click on the label)
     * Invoke {@link Replay} command and mimic the result on the UI
     * @throws NoSuchMethodException
     * @throws CloneNotSupportedException
     */
    @FXML
    void handlePlay(ActionEvent event) throws NoSuchMethodException, CloneNotSupportedException {
        this.textarea.requestFocus();
        this.currentAction = ACTION.REPLAY;
        this.setCommand(this.commandMap.get("replay"));
        this.textarea.setText(this.engine.getBufferClone().getText());
        this.currentAction = ACTION.NONE;
    }

    /**
     * @param event the ActionEvent (on click on the label)
     * Invoke {@link Record} command and mimic the same effect on the UI.
     * @throws NoSuchMethodException
     */
    @FXML
    void handleStartRecording(ActionEvent event) throws NoSuchMethodException {
        this.setCommand(this.commandMap.get("record"));
    }

    /**
     * @param event the ActionEvent (on click on the label)
     * Invoke {@link Stop} command and mimic the same effect on the UI.
     * @throws NoSuchMethodException
     */
    @FXML
    void handleStopRecording(ActionEvent event) throws NoSuchMethodException {
        this.setCommand(this.commandMap.get("stop"));
    }


    /**
     * @param command to execute
     *  Execute the given {@link Command}
     */
    public void setCommand(Command command ) throws NoSuchMethodException {
        command.execute();
    }

    /**
     * @param m {@link Map} to set
     */
    public void setCommandMap(Map<String, Command> m){
        this.commandMap = m;
    }

    /**
     * @param engine {@link Receiver} to set
     */
    public void setEngine(Receiver engine) {
        this.engine = engine;
    }


    @Override
    public void start(Stage stage){
        //application must include start
    }
}