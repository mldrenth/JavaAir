import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    private Flight flight;
    private Pilot  pilot;
    private CabinCrewMember flightAttendant1;
    private CabinCrewMember flightAttendant2;
    private Passenger passenger;
    private Plane plane;
    private ArrayList<Pilot> pilotList;
    private ArrayList<CabinCrewMember> cabinCrewList;
    private FlightManager flightManager;
    private Date date;

    @Before
    public void before(){
        passenger = new Passenger("Paul", 2);
        pilot = new Pilot("Bill", RankType.CAPTAIN, "ABC1");
        flightAttendant1 = new CabinCrewMember("Anna", RankType.FLIGHTATTENDANT);
        flightAttendant2 = new CabinCrewMember("Bob", RankType.FLIGHTATTENDANT);
        pilotList = new ArrayList<>(Arrays.asList(pilot));
        cabinCrewList = new ArrayList<>(Arrays.asList(flightAttendant1, flightAttendant2));
        plane = new Plane(PlaneType.TESTPLANE);
        date = new Date(1639739100000L);
        flight = new Flight(pilotList, cabinCrewList, plane, "FR756", "EDI", "MUC", date);
        flightManager = new FlightManager(flight);
    }


    @Test
    public void hasFlight(){
        assertEquals(flight, flightManager.getFlight());
    }

    @Test
    public void canCalculateReservedWeight(){
        assertEquals(25, flightManager.calcReservedWeight(), 0.00);
    }

    @Test
    public void canCalculateSingleBaggageWeight(){
        assertEquals(4.16, flightManager.calcSingleBaggageWeight(), 0.01);
    }

    @Test
    public void canCalculateTotalBaggageWeight(){
        flight.bookPassenger(passenger);
        assertEquals(8.33, flightManager.calcTotalBaggageWeight(), 0.01);
    }

    @Test
    public void canCalculateRemainingBaggageWeight(){
        flight.bookPassenger(passenger);
        assertEquals(16.66, flightManager.calcRemainingWeight(), 0.01);
    }
}
