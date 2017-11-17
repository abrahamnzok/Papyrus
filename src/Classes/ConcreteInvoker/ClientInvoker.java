package Classes.ConcreteInvoker;

import Classes.ConcreteCommands.*;
import Classes.ConcreteReceiver.BoardReceiver;
import Interfaces.Command.Command;
import Interfaces.Invoker.Invoker;
import Interfaces.Receiver.Receiver;
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

    @Override
    public void start(Stage stage){
        //application must include start
    }

    @FXML
    private void initialize() {
        this.textarea.requestFocus();
        this.engine = new BoardReceiver();
        this.textarea.textProperty().addListener((observable, oldValue, newValue) -> {
            textarea.setOnKeyPressed(event -> {
                int caretPosition;
                switch(event.getCode()){
                    case BACK_SPACE:
                        //Had to redefine it because the caretPosition move after pressing those keys
                        caretPosition = textarea.getCaretPosition();
                        deleteAtPosition(caretPosition-1);
                        break;
                    case DELETE:
                        caretPosition = textarea.getCaretPosition();
                        deleteAtPosition(caretPosition);
                        break;
                }
            });
            if(oldValue.length() < newValue.length()){
                int carretPosition = textarea.getCaretPosition();
                insertAtPosition(newValue, carretPosition);
            }
        });

        this.textarea.setOnMouseClicked(event -> {
            if(this.textarea.getSelection().getLength() > 0){
                this.engine.select(this.textarea.getSelection().getStart(), this.textarea.getSelection().getEnd());
            } else{
                this.engine.select(0,0);
            }
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
        Copy cpy = new Copy();
        cpy.setReceiver(this.engine);
        this.setCommand(cpy);
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
        this.textarea.requestFocus();
        int carretPosition = textarea.getCaretPosition();
        deleteAtPosition(carretPosition);
        this.textarea.setText(this.engine.getBufferClone().getText());
        //We have to position it manually or it will move to the begining of the text
        this.textarea.positionCaret(carretPosition);
    }

    /**
     * @param event the paste (on click on the button)
     * Invoke the Cut command and mimic the same effect on the UI.
     */
    @FXML
    private void handlePaste(MouseEvent event) throws CloneNotSupportedException {
        Paste paste  = new Paste();
        paste.setReceiver(this.engine);
        this.setCommand(paste);
        this.textarea.setText(this.engine.getBufferClone().getText());
    }

    /**
     * @param command to execute
     */
    public void setCommand(Command command ) {
        command.execute();
    }

}