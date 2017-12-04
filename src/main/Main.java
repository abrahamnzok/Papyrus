package main;

import classes.components.Carecorder;
import classes.components.DoUndoEngine;
import classes.concretecommands.*;
import classes.concreteinvoker.ClientInvoker;
import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.*;
import interfaces.Receiver.Receiver;
import interfaces.command.Command;
import interfaces.recordable.Recordable;
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
        Recorder carecorder = new Carecorder();
        Recorder doUndoEngine = new DoUndoEngine(engine);
        //Bind the recording engine to the main engine.
        ((BoardReceiver) engine).setRecorder(doUndoEngine);

        //The client instanciate all the commands and give them to the invoker.
        InsertRecordable insert = new InsertRecordable();
        insert.setReceiver(engine);
        insert.setRecorder(carecorder);
        DeleteRecordable delete = new DeleteRecordable();
        delete.setReceiver(engine);
        delete.setRecorder(carecorder);
        SelectionRecordable select = new SelectionRecordable();
        select.setReceiver(engine);
        select.setRecorder(carecorder);
        CutRecordable cut = new CutRecordable();
        cut.setReceiver(engine);
        cut.setRecorder(carecorder);
        CopyRecordable copy = new CopyRecordable();
        copy.setReceiver(engine);
        copy.setRecorder(carecorder);
        PasteRecordable paste = new PasteRecordable();
        paste.setReceiver(engine);
        paste.setRecorder(carecorder);

        //Macro related commands
        Record record = new Record();
        record.setReceiver(carecorder);
        Replay replay = new Replay();
        replay.setReceiver(carecorder);
        Stop stop = new Stop();
        stop.setReceiver(carecorder);

        //UndoRedo related commands
        Undo undo = new Undo();
        undo.setReceiver(doUndoEngine);
        Redo redo = new Redo();
        redo.setReceiver(doUndoEngine);

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
        commands.put("record", record);
        commands.put("stop", stop);
        commands.put("undo", undo);
        commands.put("redo", redo);

        //Giving the commands and the engine to the invoker
        controller.setCommandMap(commands);
        controller.setEngine(engine);

        //Show the User Interface
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
