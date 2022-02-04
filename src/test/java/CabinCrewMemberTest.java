import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    private CabinCrewMember cabinCrewMember;

    @Before
    public void before(){
        cabinCrewMember = new CabinCrewMember("Anna", RankType.FLIGHTATTENDANT);
    }

    @Test
    public void hasName(){
        assertEquals("Anna", cabinCrewMember.getName());
    }

    @Test
    public void hasRank(){
        assertEquals(RankType.FLIGHTATTENDANT, cabinCrewMember.getRank());
    }

    @Test
    public void canRelayMessage(){
        assertEquals("What would you like for lunch?", cabinCrewMember.relayMessage());
    }


}
