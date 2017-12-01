package classes.concretereceiver;

import classes.components.Buffer;
import classes.components.ClipBoard;
import classes.components.Ranger;
import interfaces.Receiver.Receiver;
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
        this.receiver.insert(toInsert, bufferstate.length());
        assertTrue("We need to check if we can insert at any position",
                this.buffer.getText().contains(toInsert));

    }

    @Test
    public void insertionOutOfBoundaries() throws Exception {
        String bufferstate = "";
        this.buffer.setText(bufferstate);
        String toInsert = "And I need these test to succeed";
        this.receiver.insert(toInsert, this.buffer.getText().length()-1);
        assertTrue("We cannot break boundaries when inserting",
                this.buffer.isEmpty());
    }

    @Test
    public void insertionOnTheEdge() throws Exception {
        String bufferstate = "I need money";
        this.buffer.setText(bufferstate);
        String toInsert = "And I need these test to succeed";
        this.receiver.insert(toInsert, this.buffer.getText().length());
        assertTrue("We cannot break boundaries when inserting",
                this.buffer.getText().contains(toInsert));

    }

    @Test
    public void makeSelection() throws Exception {
        int begin = 5;
        int end = 10;
        this.ranger.range(begin, end);
        assertTrue(this.ranger.getSpaceBegin() != this.ranger.getSpaceEnd());

    }

    @Test
    public void makeNoSelection() throws Exception {
        String bufferState = "Trying to select at 0?";
        this.buffer.setText(bufferState);
        int begin = 0;
        int end = 0;
        this.receiver.select(begin, end);
        assertTrue(this.ranger.getSelection().isEmpty());
    }

    @Test
    public void makeNoSelection1() throws Exception {
        String bufferState = "Trying to select at 5?";
        this.buffer.setText(bufferState);
        int begin = 5;
        int end = 5;
        this.receiver.select(begin, end);
        assertTrue(this.ranger.getSelection().isEmpty());
    }

    @Test
    public void makeSelectionNegative() throws Exception {
        int start = 10;
        int finish = 1;
        this.ranger.range(start, finish);
        assertEquals(start- finish, Math.abs(this.ranger.getSpaceEnd() - this.ranger.getSpaceBegin()));
    }

    @Test
    public void makeSelectionOutOfBoundaries() throws Exception {
        String bufferState = "I need to copy this and only this";
        this.buffer.setText(bufferState);
        int start = 0;
        int finish = bufferState.length() +  10;
        this.receiver.select(start, finish);
        assertEquals("We check we select only what we have and we don't break boundaries",
                bufferState, this.ranger.getSelection());
    }

    @Test
    public void makeSelectionOutOfBoundaries1() throws Exception {
        String bufferState = "I need to copy this and only what is expected";
        this.buffer.setText(bufferState);
        String result = "only what is expected";
        int start = bufferState.length() +  10;
        int finish = 24 ;
        this.receiver.select(start, finish);
        assertEquals("Another protection from selecting out of boundaries",
                result, this.ranger.getSelection());
    }

    @Test
    public void makeSelectionOutOfBoundaries2() throws Exception {
        String bufferState = "I need to ";
        this.buffer.setText(bufferState);
        String expected = "I need to";
        int start = 10;
        int finish = 15;
        this.receiver.select(start, finish);
        assertEquals("A second test to assure us protection from selecting out of boundaries",
                expected, this.ranger.getSelection());
    }

    @Test
    public void makeSelectionOutOfBoundaries3() throws Exception {
        String bufferState = "I need to change my clothes";
        this.buffer.setText(bufferState);
        String expected = "need to change my clothes";
        int start = 34;
        int finish = 1;
        this.receiver.select(start, finish);
        assertEquals("A third test to assure us protection from selecting out of boundaries",
                expected, this.ranger.getSelection());
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
        String selected = bufferState.substring(7, 8).trim();
        this.receiver.select(7, 8);
        assertEquals(selected,this.ranger.getSelection());
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

    @Test
    public void cut() throws Exception {
        String cut = "I need to cut text";
        this.buffer.setText(cut);
        this.receiver.select(13, cut.length());
        String selection = this.ranger.getSelection();
        this.receiver.cut();
        assertTrue("We have to check if the buffer/clipBoard is changed ",
                this.buffer.getText().contains("I need to cut") &&
                this.clipBoard.getClipboard().contains(selection));

    }

    @Test
    public void cutNothing() throws Exception {
        String cut = "I need to cut text";
        this.buffer.setText(cut);
        this.receiver.select(1, 2);
        this.receiver.cut();
        assertTrue("In case we try to cut nothing then we should ensure the buffer's state is unchanged and the clipBoard is empty",
                this.buffer.getText().contains(cut) &&
                        this.clipBoard.isEmpty() &&
                        this.ranger.isEmpty());
    }

    @Test
    public void cutOutOfBoundaries() throws Exception {
        String cut = "I need to cut text";
        this.buffer.setText(cut);
        this.receiver.select(1, 10);
        this.receiver.cut();
        this.receiver.cut();
        assertTrue("In case we try to cut out of Boundaries, We only need to cut what we have",
                this.buffer.getText().contains("I") &&
                        this.clipBoard.getClipboard().contains(this.ranger.getSelection()) &&
                        !this.ranger.getSelection().isEmpty());
    }

    @Test
    public void cutEverything() throws Exception {
        String cut = "I need to cut everything";
        this.buffer.setText(cut);
        this.receiver.select(0, cut.length());
        this.receiver.cut();
        assertTrue("We want to cut everything then we should expect the buffer to be empty and the clipboard to contain the ranger",
                this.buffer.getText().isEmpty() && this.clipBoard.getClipboard().contains(cut));
    }

    @Test
    public void multipleCuts() throws Exception {
        String cut = "cut";
        this.buffer.setText(cut);
        this.receiver.select(0, cut.length());
        String selectedToCut = this.ranger.getSelection();
        this.receiver.cut();
        this.receiver.cut();
        assertTrue("We want to avoid cut when you cannot cut",
                this.buffer.getText().isEmpty() && this.clipBoard.getClipboard().contains(selectedToCut));

    }

    @Test
    public void cuttingWithoutSelecting() throws Exception {
        String cut = "We need to multiply profits and cut taxes";
        this.buffer.setText(cut);
        this.receiver.cut();
        assertTrue("We want to avoid to cut without selecting",
                this.buffer.getText().equals(cut) &&
                        this.clipBoard.getClipboard().isEmpty() &&
                        this.ranger.getSelection().isEmpty()
        );

    }

    @Test
    public void cutsWithSelects() throws Exception {
        String cut = "We need to multiply profits and cut taxes";
        this.buffer.setText(cut);
        this.receiver.select(11, 28);
        this.receiver.cut();
        this.receiver.select(0, 14);
        this.receiver.cut();
        String resultBuffer = " cut taxes";
        String selection = "We need to and";
        String finalClipboard = "We need to and";
        assertTrue("We want to avoid cut when you cannot cut",
                this.buffer.getText().equals(resultBuffer) &&
                        this.clipBoard.getClipboard().equals(finalClipboard) &&
                        this.ranger.getSelection().equals(selection)
        );

    }


    @Test
    public void paste() throws Exception {
        String bufferState = "Test for paste";
        String clipboard = "Hope it works";
        this.buffer.setText(bufferState);
        this.clipBoard.setClipboard(clipboard);
        this.receiver.paste(0);
        assertTrue("We want to test first paste ",
                this.buffer.getText().contains(clipboard) && this.clipBoard.getClipboard().contains(clipboard));
    }

    @Test
    public void multiplePaste() throws Exception {
        String bufferState = "Test for multiple pastes";
        this.buffer.setText(bufferState);
        String clipboard = "Hope it works";
        this.clipBoard.setClipboard(clipboard);
        this.receiver.paste(0);
        this.receiver.paste(this.buffer.length()/2);
        this.receiver.paste(this.buffer.length()/4);
        Matcher m = Pattern.compile("\\bHope\\b").matcher(this.buffer.getText());
        int matches = 0;
        while(m.find())
            matches++;
        assertTrue("We want to test multiple paste",
                matches == 2 && this.clipBoard.getClipboard().contains(clipboard));
    }

    @Test
    public void multiplePaste1() throws Exception {
        String bufferState = "Test for multiple pastes";
        this.buffer.setText(bufferState);
        String clipboard = "Hope it works";
        int lengthResult = this.buffer.length() + 3 * clipboard.length();
        this.clipBoard.setClipboard(clipboard);
        this.receiver.paste(0);
        this.receiver.paste(this.buffer.length()/2);
        this.receiver.paste(this.buffer.length()/4);
        assertEquals("We want to test multiple paste",
                lengthResult, this.buffer.length());
    }


    @Test
    public void pasteNothing() throws Exception {
        String bufferState = "Test for paste nothing";
        this.buffer.setText(bufferState);
        String clipboard = "";
        this.clipBoard.setClipboard(clipboard);
        this.receiver.paste(12);
        this.receiver.paste(14);
        this.receiver.paste(this.buffer.length());
        assertTrue("We want paste when there is nothing in clipboard",
                this.buffer.getText().contains(bufferState) && this.clipBoard.getClipboard().isEmpty());
    }

    @Test
    public void pasteWhenSelecting() throws Exception {
        String bufferState = "Test for paste when selecting";
        String result = "Testing for paste when selecting";
        this.buffer.setText(bufferState);
        this.clipBoard.setClipboard("ing");
        this.receiver.select(0,4);
        this.receiver.paste(4);
        assertEquals("We want paste when there is a selection going on",
                result, this.buffer.getText());
    }
    @Test
    public void pasteWhenNothingInClipBoard() throws Exception {
        String bufferState = "Test for paste when clipboard is empty";
        this.buffer.setText(bufferState);
        this.receiver.paste(4);
        assertEquals("We want paste when clipboard is empty",
                bufferState.length(), this.buffer.length());
    }

    @Test
    public void pasteOutOfBoundaries() throws Exception {
        String bufferState = "Test for paste when clipboard";
        this.buffer.setText(bufferState);
        this.clipBoard.setClipboard(" contains something");
        this.receiver.paste(this.buffer.length()*2);
        assertEquals("We want paste when clipboard is empty",
                bufferState, this.buffer.getText());
    }

    @Test
    public void pasteOutOfBoundariesTest2() throws Exception {
        String bufferState = "Test for paste when clipboard";
        this.buffer.setText(bufferState);
        this.clipBoard.setClipboard(" contains something");
        this.receiver.paste(-1);
        assertEquals("We want paste when clipboard is empty",
                bufferState, this.buffer.getText());
    }

    @Test
    public void cutNPaste() throws Exception {
        String bufferState = "Test";
        this.buffer.setText(bufferState);
        this.receiver.select(0, bufferState.length());
        this.receiver.cut();
        this.receiver.paste(0);
        assertEquals("We want to cut and paste",
                bufferState, this.buffer.getText());
    }

    @Test
    public void copyAndCheckClipboardStaste() throws Exception {
        String bufferState = "je";
        this.buffer.setText(bufferState);
        this.receiver.select(0, bufferState.length());
        this.receiver.copy();
        this.receiver.paste(this.buffer.length()/2);
        this.receiver.select(0, this.buffer.length());
        this.receiver.copy();
        this.receiver.paste(this.buffer.length());
        assertEquals("We want paste at different positions",
                "jjeejjee", this.buffer.getText());
    }

    @Test
    public void copy() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.receiver.select(0, 3);
        this.receiver.copy();
        assertTrue("We want to test the first behaviour of copying",
                this.buffer.getText().contains(bufferState) &&
                        this.clipBoard.getClipboard().contains(this.ranger.getSelection()));
    }

    @Test
    public void copyWhenSelectionIsEmpty() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.receiver.copy();
        assertEquals("We want to test the first behaviour of copying", bufferState,this.buffer.getText());
        assertTrue(this.clipBoard.isEmpty());
    }

    @Test
    public void copyMultipleTimes() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.receiver.select(0, 1);
        this.receiver.copy();
        this.receiver.select(5, bufferState.length());
        this.receiver.copy();
        String result = this.ranger.getSelection();
        this.receiver.copy();
        this.receiver.copy();
        assertEquals("We want to test multi copying behaviour",
                result,this.clipBoard.getClipboard());
    }

    @Test
    public void copyNothing() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.receiver.select(1, 1);
        this.receiver.copy();
        System.out.println(this.clipBoard);
        /*String result = this.ranger.getSelection();
        assertEquals("Since we cannot select an empty string or character, let's try to copy nothing",
                result,this.clipBoard.getClipboard());
                */
    }

    @Test
    public void copyCutMultiplePastes() throws Exception {
        String bufferState = "I am the one who knocks";
        this.buffer.setText(bufferState);
        this.receiver.select(0, 1);
        String selected = this.ranger.getSelection();
        this.receiver.copy();
        this.receiver.cut();
        int finalLength = this.buffer.length() + this.ranger.getSelection().length() * 4;
        String clipboard = this.clipBoard.getClipboard();
        this.receiver.paste(0);
        this.receiver.paste(0);
        this.receiver.paste(0);
        this.receiver.paste(0);

        assertTrue("We want to test the first behaviour of copying",
                        finalLength == this.buffer.length() &&
                        this.buffer.getText().contains(selected) &&
                        this.clipBoard.getClipboard().contains(clipboard));
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
    public void deleteCorrectPosition0() throws Exception {
        String bufferState = "I need we need to delete this s";
        this.buffer.setText(bufferState);
        this.receiver.delete(0);
        assertTrue("Make sure we do not delete at 0!!", !this.buffer.getText().contains("I"));
    }

    @Test
    public void deleteOutOfBoundaries() throws Exception {
        String bufferState = "I love this";
        this.buffer.setText(bufferState);
        this.receiver.delete(60);
        assertEquals("We make sure that we cannot delete outOf Boundaries",
                "I love this", this.buffer.getText());
    }

}
