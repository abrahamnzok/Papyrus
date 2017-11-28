package classes.recordablecommands;

import classes.concretemementos.DeleteGhost;
import classes.concretemementos.PasteGhost;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasteRecordableTest {
    private PasteRecordable nonmocked;
    @Before
    public void setUp() throws Exception {
        this.nonmocked = new PasteRecordable();
    }

    @Test
    public void savePasteTest1() throws Exception {
        this.nonmocked.setPaste(10);
        PasteGhost pasteGhost = (PasteGhost) this.nonmocked.save();
        assertEquals(this.nonmocked.getPaste(), pasteGhost.getPositionState());
    }

    @Test
    public void savePasteTest2() throws Exception {
        this.nonmocked.setPaste(10);
        PasteGhost pasteGhost = (PasteGhost) this.nonmocked.save();
        assertEquals(this.nonmocked.getPaste(), pasteGhost.getPositionState());
    }

    @Test
    public void savePasteTest3() throws Exception {
        this.nonmocked.setPaste(10);
        assertTrue(PasteGhost.class.isInstance(this.nonmocked.save())
                && Memento.class.isInstance(this.nonmocked.save()));
    }
    @Test
    public void restorePasteTest1() throws Exception {
        this.nonmocked.setPaste(14);
        PasteGhost pasteGhost = new PasteGhost(this.nonmocked.getReceiver(),10);
        this.nonmocked.restore(pasteGhost);
        assertEquals(10, this.nonmocked.getPaste());
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.nonmocked.setPaste(14);
        DeleteGhost deletePosition = new DeleteGhost(this.nonmocked.getReceiver(),10);
        this.nonmocked.restore(deletePosition);
        assertEquals(14, this.nonmocked.getPaste());
    }

}