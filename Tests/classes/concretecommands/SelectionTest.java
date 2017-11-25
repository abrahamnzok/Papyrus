package classes.concretecommands;

import classes.concretemementos.InsertGhost;
import classes.concretemementos.SelectGhost;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;


public class SelectionTest {
    private Receiver mockreceiver;
    private Selection mockselector;
    private Selection selection;
    @Before
    public void setUp() throws Exception {
        this.mockselector = Mockito.mock(Selection.class);
        this.mockreceiver = Mockito.mock(Receiver.class);
        this.selection = new Selection(10, 12);
    }

    @Test
    public void execute() throws Exception {
        this.mockreceiver.select(0, 12);
        Mockito.verify(this.mockreceiver, Mockito.times(1)).select(0, 12);
    }

    @Test
    public void setReceiver() throws Exception {
        this.mockselector.setReceiver(this.mockreceiver);
        ArgumentCaptor<Receiver> argumentCaptor = ArgumentCaptor.forClass(Receiver.class);
        Mockito.verify(this.mockselector).setReceiver(argumentCaptor.capture());
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
        SelectGhost selection = new SelectGhost(13, 34);
        this.selection.restore(selection);
        assertTrue("We want to retrieve savedParams and check ",
                this.selection.getStart() == 13 && this.selection.getEnd() == 34);
    }

    @Test
    public void restoreCheckArgument() throws Exception {
        this.selection.setStart(12);
        this.selection.setStart(23);
        SelectGhost selector = new SelectGhost(13, 34);
        this.selection.restore(selector);
        assertTrue(Memento.class.isInstance(selector));
    }

    @Test
    public void restoreNothing() throws Exception {
        this.selection.setStart(12);
        this.selection.setStart(14);
        this.selection.restore(null);
        assertTrue(this.selection.getStart() == 12 && this.selection.getEnd() == 14);
    }

    @Test
    public void restoreWrongMemento() throws Exception {
        this.selection.setStart(14);
        this.selection.setEnd(15);
        InsertGhost insertGhost = new InsertGhost("Cant do this!",10);
        this.selection.restore(insertGhost);
        assertTrue("We are trying to retrieve last saved data of delete",
                this.selection.getStart() == 14  && this.selection.getEnd() == 15);
    }

    @Test
    public void getStart() throws Exception {
        assertEquals(10, this.selection.getStart());
    }

    @Test
    public void getEnd() throws Exception {
        assertEquals(12, this.selection.getEnd());
    }

}