package classes.components;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClipBoardTest {
    private ClipBoard clipBoard;
    @Before
    public void setUp() throws Exception {
        this.clipBoard = new ClipBoard();
    }

    @Test
    public void setSelection() throws Exception {
        String s = "Test";
        this.clipBoard.setClipboard(s);
        assertEquals(this.clipBoard.getClipboard(), s);

    }

    @Test
    public void setSelectionEmpty() throws Exception {
        String u = "ClipBoard Empty after set";
        this.clipBoard.setClipboard(u);
        assertFalse(this.clipBoard.getClipboard().isEmpty());
    }


    @Test
    public void getSelection() throws Exception {
        assertTrue(this.clipBoard.getClipboard() != null);
        assertTrue(this.clipBoard.getClipboard().getClass() == String.class);
    }

}