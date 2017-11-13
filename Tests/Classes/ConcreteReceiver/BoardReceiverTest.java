package Classes.ConcreteReceiver;

import Classes.Components.Buffer;
import Classes.Components.ClipBoard;
import Classes.Components.Ranger;
import Interfaces.Receiver.Receiver;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class BoardReceiverTest {
    private Buffer buffer;
    private ClipBoard clipBoard;
    private Ranger ranger;
    private Receiver receiver;

    @Before
    public void setUp() throws Exception {
        this.buffer = new Buffer();
        this.clipBoard = new ClipBoard();
        this.ranger = new Ranger();
        this.receiver = new BoardReceiver(this.buffer, this.clipBoard, this.ranger);
    }

    @Test
    public void cut() throws Exception {
        String cut = "I need to cut text";
        this.buffer.setText(cut);
        this.ranger.range(0, 11);
        String selection = this.ranger.getSelection();
        this.receiver.cut();
        assertTrue("We have to check if the buffer/clipBoard is changed ",
                this.buffer.getText().contains(cut.substring(12,cut.length()-1)) &&
                this.clipBoard.getClipboard().contains(selection));
    }
    @Test
    public void cutNothing() throws Exception {
        String cut = "I need to cut text";
        this.buffer.setText(cut);
        this.ranger.range(1, 2);
        String selected = this.ranger.getSelection();
        this.receiver.cut();
        assertTrue("In case we try to cut nothing then we should ensure the buffer's state is unchanged and the clipBoard is empty",
                this.buffer.getText().contains(cut) && this.clipBoard.getClipboard().isEmpty());
    }


    @Test
    public void cutEverything() throws Exception {
        String cut = "I need to cut everything";
        this.buffer.setText(cut);
        this.ranger.range(0, cut.length()-1);
        String selected = this.ranger.getSelection();
        this.receiver.cut();
        assertTrue("We want to cut everything then we should expect the buffer to be empty and the clipboard to contain the ranger",
                this.buffer.getText().isEmpty() && this.clipBoard.getClipboard().contains(cut));
    }

    @Test
    public void multipleCuts() throws Exception {
        String cut = "cut";
        this.buffer.setText(cut);
        this.ranger.range(0, cut.length()-1);
        String selected = this.ranger.getSelection();

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
    public void cutNPaste() throws Exception {
        String bufferState = "Test";
        this.buffer.setText(bufferState);
        this.ranger.range(0, 4);
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

        assertTrue("We want to cut and paste",
                matches == 3 && this.clipBoard.getClipboard().contains(clipboard));
    }

    @Test
    public void insert() throws Exception {
        String bufferstate = "";
        this.buffer.setText(bufferstate);
        String toInsert = "I need these test to be succeed a 100%";
        this.receiver.insert(toInsert, 0);
        //System.out.println(this.buffer.getText() + " /" + this.receiver.getBufferClone().getText());
        assertEquals(toInsert, this.buffer.getText());
    }

    @Test
    public void insertAtAnyPosition() throws Exception {
        String bufferstate = "Insertion at any position";
        this.buffer.setText(bufferstate);
        String toInsert = "And I need these test to succeed";
        this.receiver.insert(toInsert, this.buffer.getText().length());
        assertTrue("We need to check if we can insert at any position",
                this.buffer.getText().contains(toInsert));
    }

    @Test
    public void insertAtAnyPositionMultipleTexts() throws Exception {
        String bufferstate = "Insertion at any position with multiple input";
        this.buffer.setText(bufferstate);
        String toInsert = "And I need these test to succeed";
        String toInsert2 = "Multiple input insertion test : ";
        this.receiver.insert(toInsert, this.buffer.getText().length()-1);
        this.receiver.insert(toInsert2, 0);
        assertTrue("We need to check if we can insert at any position",
                this.buffer.getText().contains(toInsert) && this.buffer.getText().contains(toInsert2));
    }
    @Test
    public void copy() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.ranger.range(0, 1);
        this.receiver.copy();
        assertTrue("We want to test the first behaviour of copying",
                this.buffer.getText().contains(bufferState) && this.clipBoard.getClipboard().contains("I"));
    }

    @Test
    public void multipleCopies() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.ranger.range(0, 1);
        this.receiver.copy();
        this.receiver.copy();
        this.receiver.copy();
        assertTrue("We want to test the first behaviour of copying",
                this.buffer.getText().contains(bufferState) && this.clipBoard.getClipboard().contains("I"));
    }

    @Test
    public void copyCutMultiplePastes() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.ranger.range(0, 1);
        String selected = this.ranger.getSelection();
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
        String bufferState = "I need we need to delete that s";
        this.buffer.setText(bufferState);
        int lengthBeforeDelete  = this.buffer.getText().length() - 1;
        this.receiver.delete(bufferState.length()-1);
        assertTrue("We want to check that the buffer doesn't contain s char",
                this.receiver.getBufferClone().getText().length() == lengthBeforeDelete &&
                        !this.receiver.getBufferClone().getText().contains("s"));

    }
    @Test
    public void deleteNothing() throws Exception {
        String bufferState = "";
        this.buffer.setText(bufferState);
        this.receiver.delete(bufferState.length());
        this.receiver.delete(bufferState.length());
        assertTrue("We cannot allow deletion if buffer is empty",
                this.receiver.getBufferClone().getText().isEmpty());
    }
    @Test
    public void deleteEverything() throws Exception {
        String bufferState = "Moi";
        this.buffer.setText(bufferState);
        int i = bufferState.length()-1;
        while (i > 0){
            this.receiver.delete(i);
            i--;
        }
        this.receiver.delete(i);
        assertTrue("We want to check if we can delete the whole text in the buffer",
                this.buffer.getText().isEmpty());
    }
    @Test
    public void deleteButPositionTooHigh() throws Exception {
        String bufferState = "We need to check consecutive delete and we need to see if the buffer is empty at the end";
        this.buffer.setText(bufferState);
        int positionToHigh = bufferState.length() + 5;
        this.receiver.delete(positionToHigh);
        assertTrue("We don't want to delete when position in to high",
                this.buffer.getText().equals(bufferState));
    }

    @Test
    public void deleteAtAnyPosition() throws Exception {
        String bufferState = "I need we need to delete this s";
        this.buffer.setText(bufferState);
        this.receiver.delete(bufferState.length()-1);
        this.receiver.delete((bufferState.length()-1)/2);
        int lengthBeforeDelete = bufferState.length() - 2;
        assertEquals("We make sure that we can delete at any position",
                lengthBeforeDelete, this.buffer.getText().length());
    }
    @Test
    public void correctPosition0() throws Exception {
        String bufferState = "I need we need to delete this s";
        this.buffer.setText(bufferState);
        this.receiver.delete(0);
        assertTrue("Make sure we do not delete at 0!!", !this.buffer.getText().contains("I"));
    }

    @Test
    public void makeSelection() throws Exception {
        int begin = 5;
        int end = 10;
        this.ranger.range(begin, end);
        assertTrue(this.ranger.getSpaceBegin() != this.ranger.getSpaceEnd());

    }

    @Test
    public void makeSelectionNegative() throws Exception {
        int start = 10;
        int finish = 1;
        this.ranger.range(start, finish);
        assertEquals(start- finish, Math.abs(this.ranger.getSpaceEnd() - this.ranger.getSpaceBegin()));
    }

    @Test
    public void makeFirstSelection() throws Exception {
        String s = "Try to select me";
        this.buffer.setText(s);
        int begin = 0;
        int end = 14;
        String selected = s.substring(begin, 13);
        this.receiver.select(begin, end);
        assertEquals(selected, this.ranger.getSelection());

    }

    @Test
    public void makeSelectionInverse() throws Exception {
        String s = "Try to select me";
        this.buffer.setText(s);
        int beginInverse = 14;
        int endInverse = 0;
        String selectedInverse = s.substring(endInverse, 13);
        this.receiver.select(beginInverse, endInverse);
        assertEquals(selectedInverse, this.ranger.getSelection());
    }

    @Test
    public void makeSelectionAvoidEmpty1() throws Exception {
        String bufferState = "I want to try to copy everything except this  ";
        this.buffer.setText(bufferState);
        String selected = bufferState.substring(0, 44);
        this.receiver.select(0, 44);
        assertEquals(selected, this.ranger.getSelection());
    }

    @Test
    public void makeSelectionAvoidEmpty2() throws Exception {
        String bufferState = "Testing is great";
        this.buffer.setText(bufferState);
        String selected = bufferState.substring(7, 8);
        this.receiver.select(7, 8);
        assertEquals("",this.ranger.getSelection());
    }

    @Test
    public void makeSelectionWithSomeMultipleEmptyChars() throws Exception {
        String bufferState = "Testing  is the   keystone of development";
        this.buffer.setText(bufferState);
        String selected = "is the";
        this.receiver.select(7, 18);
        assertEquals(selected,this.ranger.getSelection());
    }

    @Test
    public void makeSelectionAvoidEmpty3() throws Exception {
        String bufferState = "I want to try to copy everything except this";
        String selected = bufferState.substring(1, 2);
        System.out.println(selected);
        this.ranger.range(1, 2);
        assertFalse(this.ranger.getSelection().equals(bufferState));
    }
}
