package classes.components;

import classes.concretereceiver.BoardReceiver;
import classes.recordablecommands.CopyRecordable;
import classes.recordablecommands.InsertRecordable;
import interfaces.Receiver.Receiver;
import interfaces.memento.Memento;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class PairTest {
    private CopyRecordable copyRecordable;
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
        Pair<String, Integer> pair1 = new Pair<>("Moi", 1);
        Pair<String, Integer> pair2 = new Pair<>("Moi", 1);
        assertTrue("Comparing two pairs with primitive types elements",
                pair1.equals(pair2) && pair2.equals(pair1));
    }

    @Test
    public void pairTest3() throws Exception{
        this.insertRecordable.setReceiver(this.receiver);
        this.insertRecordable.setTextinput("Yeap me");
        this.insertRecordable.setPosition(0);
        Pair<Class, Memento> pair = new Pair<>(this.insertRecordable.getClass(), this.insertRecordable.save());
        Pair<Class, Memento> pair1 = new Pair<>(this.insertRecordable.getClass(), this.insertRecordable.save());
        assertTrue(pair.equals(pair1));
    }

    @Test
    public void pairTest4() throws Exception{
        this.copyRecordable.setReceiver(this.receiver);
        Pair<Constructor, Memento> pair = new Pair<>(this.copyRecordable.getClass().getConstructor(), this.copyRecordable.save());
        Pair<Constructor, Memento> pair1 = new Pair<>(this.copyRecordable.getClass().getConstructor(), this.copyRecordable.save());
        assertEquals(pair.getKey().hashCode(), pair1.getKey().hashCode());
    }

    @Test
    public void pairTest5() throws Exception{
        this.copyRecordable.setReceiver(this.receiver);
        Pair<Constructor, Memento> pair = new Pair<>(this.copyRecordable.getClass().getConstructor(), this.copyRecordable.save());
        Pair<Constructor, Memento> pair1 = new Pair<>(this.copyRecordable.getClass().getConstructor(), this.copyRecordable.save());
        assertTrue(pair.equals(pair1) && pair1.equals(pair));
    }

    @Test
    public void pairTest6() throws Exception{
        this.copyRecordable.setReceiver(this.receiver);
        this.insertRecordable.setReceiver(this.receiver);
        Pair<Constructor, Memento> pair = new Pair<>(this.copyRecordable.getClass().getConstructor(), this.copyRecordable.save());
        Pair<Constructor, Memento> pair1 = new Pair<>(this.insertRecordable.getClass().getConstructor(), this.insertRecordable.save());
        assertNotEquals(true, pair1.equals(pair));
    }

    @Test
    public void hashCodeTest1() throws Exception{
        this.insertRecordable.setReceiver(this.receiver);
        Pair<Constructor, Memento> pair1 = new Pair<>(this.insertRecordable.getClass().getConstructor(), this.insertRecordable.save());
        assertTrue(pair1.hashCode() != 0);
    }


}