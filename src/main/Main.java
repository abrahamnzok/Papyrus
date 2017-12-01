package main;

import classes.concretecommands.*;
import classes.concreteinvoker.ClientInvoker;
import classes.concretereceiver.BoardReceiver;
import interfaces.Receiver.Receiver;
import interfaces.command.Command;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * Configurator
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Loading the resources
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/index.fxml"));
        Parent root = fxmlLoader.load();
        ClientInvoker controller = fxmlLoader.getController();

        //The client instanciate all the engines
        Receiver engine = new BoardReceiver();

        //The client instanciate all the commands and give them to the invoker.
        Insert insert = new Insert();
        insert.setReceiver(engine);
        Delete delete = new Delete();
        delete.setReceiver(engine);
        Selection select = new Selection();
        select.setReceiver(engine);
        Cut cut = new Cut();
        cut.setReceiver(engine);
        Copy copy = new Copy();
        copy.setReceiver(engine);
        Paste paste = new Paste();
        paste.setReceiver(engine);

        Map<String, Command> commands = new HashMap<>();
        commands.put("insert", insert);
        commands.put("delete", delete);
        commands.put("selection", select);
        commands.put("cut", cut);
        commands.put("copy", copy);
        commands.put("paste", paste);

        controller.setCommandMap(commands);
        controller.setEngine(engine);

        //Show the IHM
        Scene s = new Scene(root, 1080, 720);
        s.getStylesheets().add(getClass().getResource("/views/add.css").toExternalForm());
        primaryStage.getIcons().add(new Image(getClass().getResource("/resources/logosmall.png").toExternalForm()));
        primaryStage.setTitle("Papyrus");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
