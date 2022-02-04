import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    private Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot("Bill", RankType.CAPTAIN, "ABC1");
    }

    @Test
    public void hasTest(){
        assertEquals("Bill", pilot.getName());
    }

    @Test
    public void hasRank(){
        assertEquals(RankType.CAPTAIN, pilot.getRank());
    }

    @Test
    public void hasLicenceNumber(){
        assertEquals("ABC1", pilot.getPilotLicenceNumber());
    }

    @Test
    public void canFly(){
        assertEquals("I am flying the plane!", pilot.fly());
    }
}
