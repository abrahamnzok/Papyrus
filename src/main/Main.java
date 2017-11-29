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
 * Client
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Loading the resources
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/index.fxml"));
        Parent root = fxmlLoader.load();
        ClientInvoker controller = fxmlLoader.getController();

        //The client instanciate all the engines
        Receiver engine = new BoardReceiver();

        //The client instanciate all the commands and give them to the invoker.
        Insert insert = new Insert(engine);
        Delete delete = new Delete(engine);
        Selection select = new Selection(engine);
        Cut cut = new Cut(engine);
        Copy copy = new Copy(engine);
        Paste paste = new Paste(engine);

        HashMap commands = new HashMap<String, Command>();
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
        s.getStylesheets().add(Main.class.getResource("../views/add.css").toExternalForm());
        primaryStage.setTitle("Papyrus");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
