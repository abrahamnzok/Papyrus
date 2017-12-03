package classes.components;

import org.junit.Before;
import org.junit.Test;
import java.util.Objects;

import static org.junit.Assert.*;

public class BufferTest {

    private Buffer buffer;

    @Before
    public void setUp() throws Exception {
        this.buffer = new Buffer();
    }

    /**
     * {@link Buffer} content must be what we set it to be
     * @result true
     * @throws Exception
     */
    @Test
    public void setText() throws Exception {
        String s = "This is the Buffer";
        this.buffer.setText(s);
        assertEquals(s, this.buffer.getText());
    }

    /**
     * The {@link Buffer} content must be what we set it to be
     * @result true
     * @throws Exception
     */
    @Test
    public void setTextNotEmpty() throws Exception {
        String o = "Buffer empty";
        this.buffer.setText(o);
        assertFalse("Buffer might be Empty", this.buffer.getText().isEmpty());
    }

    /**
     * The {@link Buffer} content must be what we set it to be
     * @result true
     * @throws Exception
     */
    @Test
    public void getText() throws Exception {
        String s = "Dummy Test";
        this.buffer.setText(s);
        assertTrue(!Objects.equals(this.buffer.getText(), ""));
    }

    /**
     * If the {@link Buffer} content is set, when we return it it can never be empty
     * @result false
     * @throws Exception
     */
    @Test
    public void getTextEmpty() throws Exception {
        String s = "Dummy Test";
        this.buffer.setText(s);
        assertFalse(this.buffer.getText().isEmpty());
    }
}