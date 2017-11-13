package Classes.ConcreteReceiver;

import Classes.Components.Buffer;
import Classes.Components.ClipBoard;
import Classes.Components.Selection;
import Interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class BoardReceiverTest {
    private Buffer buffer;
    private ClipBoard clipBoard;
    private Selection selection;
    private Receiver receiver;

    @Before
    public void setUp() throws Exception {
        this.buffer = new Buffer();
        this.clipBoard = new ClipBoard();
        this.selection = new Selection();
        this.receiver = new BoardReceiver();
    }

    @Test
    public void cut() throws Exception {
        String cut = "I need to cut text";
        this.buffer.setText(cut);
        this.selection.makeSelection(0, 11);
        String selection = this.selection.getSelection();
        this.receiver.cut();
        assertTrue("We have to check if the buffer/clipBoard is changed ",
                this.buffer.getText().contains(cut.substring(12,cut.length()-1)) &&
                this.clipBoard.getClipboard().contains(selection));
    }
    @Test
    public void cutNothing() throws Exception {
        String cut = "I need to cut text";
        this.buffer.setText(cut);
        this.selection.makeSelection(1, 2);
        String selected = this.selection.getSelection();
        this.receiver.cut();
        assertTrue("In case we try to cut nothing then we should ensure the buffer's state is unchanged and the clipBoard is empty",
                this.buffer.getText().contains(cut) && this.clipBoard.getClipboard().isEmpty());
    }


    @Test
    public void cutEverything() throws Exception {
        String cut = "I need to cut everything";
        this.buffer.setText(cut);
        this.selection.makeSelection(0, cut.length()-1);
        String selected = this.selection.getSelection();
        this.receiver.cut();
        assertTrue("We want to cut everything then we should expect the buffer to be empty and the clipboard to contain the selection",
                this.buffer.getText().isEmpty() && this.clipBoard.getClipboard().contains(cut));
    }

    @Test
    public void multipleCuts() throws Exception {
        String cut = "cut";
        this.buffer.setText(cut);
        this.selection.makeSelection(0, cut.length()-1);
        String selected = this.selection.getSelection();

        this.receiver.cut();
        this.receiver.cut();

        String bufferState = this.buffer.getText();

        assertTrue("We want to avoid cut when you cannot cut",
                this.buffer.getText().equals(bufferState) && this.clipBoard.getClipboard().contains(selected));

    }


    @Test
    public void paste() throws Exception {
        String bufferState = "Test for paste";
        String clipboard = "Hope it works";
        this.buffer.setText(bufferState);
        this.receiver.paste();
        assertTrue("We want to test first paste ",
                this.buffer.getText().contains(clipboard) && this.clipBoard.getClipboard().contains(clipboard));
    }

    @Test
    public void multiplePaste() throws Exception {
        String bufferState = "Hope it works Test for multiple pastes Hope it works Hope it works";
        String clipboard = "Hope it works";
        this.buffer.setText(clipboard);
        this.receiver.paste();
        this.receiver.paste();
        this.receiver.paste();

        Matcher m = Pattern.compile("\\bHope\\b").matcher(this.buffer.getText());

        int matches = 0;
        while(m.find())
            matches++;

        System.out.println(matches);
        assertTrue("We want to test multiple paste",
                matches == 3 && this.clipBoard.getClipboard().contains(clipboard));

    }

    @Test
    public void pasteNothing() throws Exception {
        String bufferState = "Test for paste nothing";
        String clipboard = "";

        this.receiver.paste();
        this.receiver.paste();
        this.receiver.paste();

        assertTrue("We want paste when there is nothing in clipboard",
                this.buffer.getText().contains(bufferState) && this.clipBoard.getClipboard().contains(clipboard));


    }

    @Test
    public void cutNpaste() throws Exception {
        String bufferState = "Test";
        this.buffer.setText(bufferState);
        this.selection.makeSelection(0, 4);
        this.receiver.cut();
        String clipboard = this.clipBoard.getClipboard();
        this.receiver.paste();
        this.receiver.paste();
        this.receiver.paste();
        String result = "Test Test Test";
        Matcher m = Pattern.compile("\\bTest\\b").matcher(this.buffer.getText());
        int matches = 0;
        while(m.find())
            matches++;

        System.out.println(matches);
        assertTrue("We want to cut and paste",
                matches == 3 && this.clipBoard.getClipboard().contains(clipboard));
    }

    @Test
    public void insert() throws Exception {
        String bufferstate = "";
        this.buffer.setText(bufferstate);
        String toInsert = "I need these test to be succeed a 100%";
        this.receiver.insert(toInsert, 0);
        assertEquals(toInsert, this.buffer.getText());
    }

    @Test
    public void insertAtAnyPosition() throws Exception {
        String bufferstate = "Insertion at any position";
        this.buffer.setText(bufferstate);
        String toInsert = "And I need these test to succeed";
        this.receiver.insert(toInsert, this.buffer.getText().length()/2 - 1);
        assertEquals(this.buffer.getText().indexOf(toInsert), this.buffer.getText().length()/2 - 1);
    }

    @Test
    public void copy() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.selection.makeSelection(0, 1);
        this.receiver.copy();
        assertTrue("We want to test the first behaviour of copying",
                this.buffer.getText().contains(bufferState) && this.clipBoard.getClipboard().contains("I"));
    }

    @Test
    public void multiplecopies() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.selection.makeSelection(0, 1);
        this.receiver.copy();
        this.receiver.copy();
        this.receiver.copy();
        assertTrue("We want to test the first behaviour of copying",
                this.buffer.getText().contains(bufferState) && this.clipBoard.getClipboard().contains("I"));
    }

    @Test
    public void copycutmultiplepastes() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.selection.makeSelection(0, 1);
        String selected = this.selection.getSelection();
        this.receiver.copy();
        this.receiver.cut();
        this.receiver.paste();
        this.receiver.paste();
        Matcher m = Pattern.compile("\\bI\\b").matcher(this.buffer.getText());
        int matches = 0;
        while(m.find())
            matches++;
        System.out.println(matches);
        assertTrue("We want to test the first behaviour of copying",
                matches == 2 && this.buffer.getText().contains(selected) && this.clipBoard.getClipboard().contains(selected));

    }

    @Test
    public void delete() throws Exception {
        String bufferState = "I need We need";
        this.buffer.setText(bufferState);
        this.selection.makeSelection(0, 1);
        String selected = this.selection.getSelection();
        this.receiver.delete();
        assertTrue("We want to check that the buffer doesn't contain I",
                !this.buffer.getText().contains(selected));
    }

}