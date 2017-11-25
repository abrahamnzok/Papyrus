package classes.concretemementos;

import classes.concretecommands.Delete;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteGhostTest {
    private DeleteGhost deleteGhost;
    private Delete delete;
    @Before
    public void setUp() throws Exception {
        this.deleteGhost = new DeleteGhost(23);
        this.delete = new Delete(23);
    }

    @Test
    public void getPositionState() throws Exception {
        assertEquals(23, this.deleteGhost.getPositionState());
    }

}