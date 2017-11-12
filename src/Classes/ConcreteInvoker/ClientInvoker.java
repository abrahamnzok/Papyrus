package Classes.ConcreteInvoker;

import Interfaces.Command.Command;
import Interfaces.Invoker.Invoker;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.*;

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

    /**
     * Default constructor
     */
    public ClientInvoker() {
    }

    @Override
    public void start(Stage stage){

        //On change listener for the textarea to detect key typed
        this.textarea.textProperty().addListener((observable, oldValue, newValue) -> {
            //Call insert command by taking the next character typed after the caret
        });
    }

    /**
     * @param command
     * @return
     */
    public void setCommand(Command command ) {
        // TODO implement here
        command.execute();
    }

}