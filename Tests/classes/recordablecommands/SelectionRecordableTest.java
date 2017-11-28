package classes.recordablecommands;

import classes.concretemementos.InsertGhost;
import classes.concretemementos.SelectGhost;
import classes.concretereceiver.BoardReceiver;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionRecordableTest {
    private SelectionRecordable selection;
    @Before
    public void setUp() throws Exception {
        this.selection = new SelectionRecordable(10, 12);
    }

    @Test
    public void saveTest1() throws Exception {
        SelectGhost selectGhost =(SelectGhost) this.selection.save();
        assertEquals(selectGhost.getEndState(), this.selection.getEnd());
    }

    @Test
    public void saveTest2() throws Exception {
        this.selection.setStart(10);
        this.selection.setStart(23);
        SelectGhost selectGhost =(SelectGhost) this.selection.save();
        assertEquals(this.selection.getStart(), selectGhost.getStartState());
    }

    @Test
    public void saveTest3() throws Exception {
        this.selection.setStart(10);
        this.selection.setStart(23);
        SelectGhost selectGhost =(SelectGhost) this.selection.save();
        assertEquals(this.selection.getEnd(), selectGhost.getEndState());
    }

    @Test
    public void saveTest4() throws Exception {
        SelectGhost selectGhost =(SelectGhost) this.selection.save();
        assertEquals(this.selection.getStart(), selectGhost.getStartState());
    }

    @Test
    public void saveTest5() throws Exception {
        assertTrue(SelectGhost.class.isInstance(this.selection.save())
                && Memento.class.isInstance(this.selection.save()));
    }

    @Test
    public void restore() throws Exception {
        this.selection.setStart(12);
        this.selection.setStart(23);
        SelectGhost selection = new SelectGhost(this.selection.getReceiver(),13, 34);
        this.selection.restore(selection);
        assertTrue("We want to retrieve savedParams and check ",
                this.selection.getStart() == 13 && this.selection.getEnd() == 34);
    }

    @Test
    public void restoreCheckArgument() throws Exception {
        this.selection.setStart(12);
        this.selection.setEnd(23);
        SelectGhost selector = new SelectGhost(this.selection.getReceiver(),13, 34);
        this.selection.restore(selector);
        assertTrue(Memento.class.isInstance(selector) && BoardReceiver.class.isInstance(this.selection.getReceiver()));
    }

    @Test
    public void restoreNothing() throws Exception {
        this.selection.setStart(12);
        this.selection.setEnd(14);
        this.selection.restore(null);
        assertTrue(this.selection.getStart() == 12 && this.selection.getEnd() == 14);
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.selection.setStart(14);
        this.selection.setEnd(15);
        InsertGhost insertGhost = new InsertGhost(this.selection.getReceiver(),"Cant do this!",10);
        this.selection.restore(insertGhost);
        assertTrue("We are trying to retrieve last saved data of delete",
                this.selection.getStart() == 14  && this.selection.getEnd() == 15);
    }

}