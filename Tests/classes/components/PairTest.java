package classes.components;

import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.CopyRecordable;
import classes.recordablecommands.CutRecordable;
import classes.recordablecommands.InsertRecordable;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {
    private CopyRecordable copyRecordable;
    private CutRecordable cutRecordable;
    private InsertRecordable insertRecordable;
    private Receiver receiver;
    @Before
    public void setUp() throws Exception {
        this.copyRecordable = new CopyRecordable();
        this.insertRecordable = new InsertRecordable();
        this.receiver = new BoardReceiver();
    }

    @Test
    public void pairTest1() throws Exception{
        this.copyRecordable.setReceiver(this.receiver);
        Pair<Class, Memento> pair = new Pair<>(this.copyRecordable.getClass(), this.copyRecordable.save());
        assertEquals("First Equal Test", pair, pair);
    }

    @Test
    public void pairTest2() throws Exception{
        this.copyRecordable.setReceiver(this.receiver);
        Pair<Class, Memento> pair = new Pair<Class, Memento>(this.copyRecordable.getClass(), this.copyRecordable.save());
        Pair<Class, Memento> pair1 = new Pair<Class, Memento>(Class.class, this.copyRecordable.save());
        System.out.println(pair.hashCode());
    }

    @Test
    public void pairTest3() throws Exception{

    }

    @Test
    public void pairTest4() throws Exception{

    }

    @Test
    public void pairTest5() throws Exception{
        this.cutRecordable.setReceiver(this.receiver);
        Pair<Class, Memento> pair = new Pair<>(this.cutRecordable.getClass(), this.cutRecordable.save());
        Pair<Class, Memento> pair1 = new Pair<>(this.copyRecordable.getClass(), this.copyRecordable.save());
        assertNotEquals(pair.getKey(), pair1.getKey());
    }

    @Test
    public void pairTest6() throws Exception{

    }


}