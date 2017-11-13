package Classes.Components;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SelectionTest {

    private Selection selection;
    private Buffer buffer;

    @Before
    public void setUp() throws Exception {
        this.selection = new Selection();
        this.buffer = new Buffer();
    }

    @Test
    public void makePosition() throws Exception {
        int begin = 5;
        int end = 10;
        this.selection.makeSelection(begin, end);
        assertTrue(this.selection.getSpaceBegin() != this.selection.getSpaceEnd());

    }

    @Test
    public void makePositionNegative() throws Exception {
        int start = 10;
        int finish = 1;

        this.selection.makeSelection(finish, start );
        assertEquals(start- finish, Math.abs(this.selection.getSpaceEnd() - this.selection.getSpaceBegin()));
    }

    @Test
    public void makeSelection() throws Exception {
        String s = "Try to select me";
        this.buffer.setText(s);
        int begin = 0;
        int end = 14;
        String selected = s.substring(begin, end);
        this.selection.makeSelection(begin, end);
        assertEquals(selected, this.selection.getSelection());

    }

    @Test
    public void makeSelectionInverse() throws Exception {
        String s = "Try to select me";

        int beginInverse = 14;
        int endInverse = 0;

        String selectedInverse = s.substring(endInverse, beginInverse);
        this.selection.makeSelection(endInverse, beginInverse);

        assertEquals(selectedInverse, this.selection.getSelection());

    }

    @Test
    public void makeSelectionAvoidEmpty1() throws Exception {
        String s = "I want to try to copy everything exept this  ";
        String selected = s.substring(0, 43);
        this.selection.makeSelection(0, 43);
        assertEquals(selected, this.selection.getSelection());
    }

    @Test
    public void makeSelectionAvoidEmpty2() throws Exception {
        String s = "I want to try to copy everything exept this";
        String selected = s.substring(0, 9);
        this.selection.makeSelection(0, 10);
        assertEquals(selected, this.selection.getSelection());
    }

    @Test
    public void makeSelectionAvoidEmpty3() throws Exception {
        String s = "I want to try to copy everything except this";
        String selected = s.substring(1, 2);
        System.out.println(selected);
        this.selection.makeSelection(1, 2);
        assertFalse(this.selection.getSelection().equals(s));
    }

    @Test
    public void getSpaceBegin() throws Exception {
        assertTrue(this.selection.getSpaceBegin() >= 0);
    }

    @Test
    public void getSpaceEnd() throws Exception {
        assertTrue(this.selection.getSpaceEnd() >= 0);
    }


    @Test
    public void getSelectedText() throws Exception {
        assertFalse(this.selection.getSelection().equals("") ||
                this.selection.getSelection().getClass().equals(String.class));
    }

    @Test
    public void getSelectedTextNull() throws Exception {
        assertFalse(this.selection.getSelection() == null);
    }

}