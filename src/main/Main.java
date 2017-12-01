package main;

import classes.components.Carecorder;
import classes.concretecommands.*;
import classes.concreteinvoker.ClientInvoker;
import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.*;
import interfaces.Receiver.Receiver;
import interfaces.command.Command;
import interfaces.recorder.Recorder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Loading the resources
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/index.fxml"));
        Parent root = fxmlLoader.load();
        ClientInvoker controller = fxmlLoader.getController();

        //The client instanciate all the engines
        Receiver engine = new BoardReceiver();
        Recorder recorder = new Carecorder();

        //The client instanciate all the commands and give them to the invoker.
        InsertRecordable insert = new InsertRecordable();
        insert.setReceiver(engine);
        insert.setRecorder(recorder);
        DeleteRecordable delete = new DeleteRecordable();
        delete.setReceiver(engine);
        delete.setRecorder(recorder);
        SelectionRecordable select = new SelectionRecordable();
        select.setReceiver(engine);
        select.setRecorder(recorder);
        CutRecordable cut = new CutRecordable();
        cut.setReceiver(engine);
        cut.setRecorder(recorder);
        CopyRecordable copy = new CopyRecordable();
        copy.setReceiver(engine);
        copy.setRecorder(recorder);
        PasteRecordable paste = new PasteRecordable();
        paste.setReceiver(engine);
        paste.setRecorder(recorder);

        //Macro related commands
        Record record = new Record();
        record.setReceiver(recorder);
        Replay replay = new Replay();
        replay.setReceiver(recorder);
        Stop stop = new Stop();
        stop.setReceiver(recorder);

        Map<String, Command> commands = new HashMap<>();
        commands.put("insert", insert);
        commands.put("delete", delete);
        commands.put("selection", select);
        commands.put("cut", cut);
        commands.put("copy", copy);
        commands.put("paste", paste);
        commands.put("replay", replay);
        commands.put("record", record);
        commands.put("stop", stop);

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
