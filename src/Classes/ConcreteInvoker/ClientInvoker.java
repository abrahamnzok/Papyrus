package Classes.ConcreteInvoker;

import Classes.ConcreteCommands.Insert;
import Classes.ConcreteReceiver.BoardReceiver;
import Interfaces.Command.Command;
import Interfaces.Invoker.Invoker;
import Interfaces.Receiver.Receiver;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
        //Initialize the person table with the two columns.
        //On change listener for the textarea to detect key typed
        this.engine = new BoardReceiver();
        this.textarea.textProperty().addListener((observable, oldValue, newValue) -> {
            //Call insert command by taking the next character typed after the caret
            int carretPosition = textarea.getCaretPosition();
            Insert insert = new Insert(Character.toString(newValue.charAt(carretPosition)), carretPosition);
            insert.setReceiver(this.engine);
            this.setCommand(insert);
            /*
             TODO Gerer la suppression de texte avec retour arrière et delete (ou clique droit supprimer),
             Si on supprime un truc actuellement renvoie une erreur si on reesaie d'entrer un caractère (index out of bound)
             + tester si la position > texte.length , si oui on met a .length, sinon osef
             */
        });
    }

    /**
     * @param command
     */
    public void setCommand(Command command ) {
        // TODO implement here
        command.execute();
    }

}