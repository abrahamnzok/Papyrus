package Classes.Components;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    private Ranger ranger;
    @Before
    public void setUp() throws Exception {
        this.ranger = new Ranger();
    }

    @Test
    public void range() throws Exception {
        int begin = 14;
        int end = 23;
        this.ranger.range(begin, end);
        assertTrue("We check normal assignment",
                this.ranger.getSpaceBegin() == begin && this.ranger.getSpaceEnd() == end);
    }

    @Test
    public void rangeInverted() throws Exception {
        int begin = 14;
        int end = 0;
        this.ranger.range(begin, end);
        assertTrue("We check inverted assignment",
                this.ranger.getSpaceBegin() < this.ranger.getSpaceEnd());
    }

    @Test
    public void getSpaceBegin() throws Exception {
        int begin = 14;
        this.ranger.range(begin, 34);
        assertTrue("We check if assignment is ok" , this.ranger.getSpaceBegin() == begin);
    }

    @Test
    public void getSpaceEnd() throws Exception {
        int end = 14;
        int begin = 0;
        this.ranger.range(begin, end);
        assertTrue("We check if assignment is ok", this.ranger.getSpaceEnd() == end);
    }

    @Test
    public void setSelection() throws Exception {
        String s = "This is the selection";
        this.ranger.setSelection(s);
        assertEquals(s, this.ranger.getSelection());
    }

    @Test
    public void getSelection() throws Exception {
        String s = "This is the selection";
        this.ranger.setSelection(s);
        assertEquals(s, this.ranger.getSelection());
    }

    @Test
    public void checkingForEmptyChar() throws Exception {
        String s = " ";
        assertEquals(true, this.ranger.isEmptyChar(s));
    }

    @Test
    public void checkingForMultipleEmptyChars() throws Exception {
        String s = "     ";
        assertEquals(true, this.ranger.isEmptyChar(s));
    }

    @Test
    public void filterEmptyChars() throws Exception {
    }

}