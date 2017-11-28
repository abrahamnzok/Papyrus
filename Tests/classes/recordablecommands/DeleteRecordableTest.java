package classes.recordablecommands;

import classes.concretemementos.DeleteGhost;
import classes.concretemementos.InsertGhost;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteRecordableTest {
    private DeleteRecordable nonmockedelete;
    @Before
    public void setUp() throws Exception {
        this.nonmockedelete = new DeleteRecordable();
    }

    @Test
    public void saveDeleteTest1() throws Exception {
        this.nonmockedelete.setPosition(10);
        DeleteGhost pasteGhost = (DeleteGhost) this.nonmockedelete.save();
        assertEquals(this.nonmockedelete.getPosition(), pasteGhost.getPositionState());
    }

    @Test
    public void saveDeleteTest2() throws Exception {
        this.nonmockedelete.setPosition(10);
        DeleteGhost pasteGhost = (DeleteGhost) this.nonmockedelete.save();
        assertEquals(this.nonmockedelete.getPosition(), pasteGhost.getPositionState());
    }

    @Test
    public void saveDeleteTest3() throws Exception {
        this.nonmockedelete.setPosition(10);
        assertTrue(DeleteGhost.class.isInstance(this.nonmockedelete.save())
                && Memento.class.isInstance(this.nonmockedelete.save()));
    }
    @Test
    public void restoreDeleteTest1() throws Exception {
        this.nonmockedelete.setPosition(14);
        DeleteGhost pasteGhost = new DeleteGhost(this.nonmockedelete.getReceiver(),10);
        this.nonmockedelete.restore(pasteGhost);
        assertEquals("We are trying to retrieve last saved data of delete",
                10, this.nonmockedelete.getPosition());
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.nonmockedelete.setPosition(14);
        InsertGhost insertGhost = new InsertGhost(this.nonmockedelete.getReceiver(),"Cant do this!",10);
        this.nonmockedelete.restore(insertGhost);
        assertEquals("We are trying to retrieve last saved data of delete",
                this.nonmockedelete.getPosition(), 14);
    }

}