import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Pilot  pilot;
    private CabinCrewMember flightAttendant1;
    private CabinCrewMember flightAttendant2;
    private Passenger passenger;
    private Plane plane;
    private ArrayList<Pilot> pilotList;
    private ArrayList<CabinCrewMember> cabinCrewList;

    @Before
    public void before(){
        pilot = new Pilot("Bill", RankType.CAPTAIN, "ABC1");
        flightAttendant1 = new CabinCrewMember("Anna", RankType.FLIGHTATTENDANT);
        flightAttendant2 = new CabinCrewMember("Bob", RankType.FLIGHTATTENDANT);
        pilotList = new ArrayList<>(Arrays.asList(pilot));
        cabinCrewList = new ArrayList<>(Arrays.asList(flightAttendant1, flightAttendant2));
        plane = new Plane(PlaneType.TWINTURBOPROPS);
        flight = new Flight(pilotList, cabinCrewList, plane, "FR756", "EDI", "MUC", "17/12/2021 13:05:24");
    }

    @Test
    public void has1Pilot(){
        assertEquals(1, flight.getNumberOfPilots());
    }

    @Test
    public void has2CabinCrew(){
        assertEquals(2, flight.getNumberOfCabinCrew());

    }
    @Test
    public void hasEmptyPassengerList(){
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    public void hasPlane(){
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("FR756", flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals("EDI", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport(){
        assertEquals("MUC", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime(){
        assertEquals("17/12/2021 13:05:24", flight.getDepartureTime());
    }

    @Test
    public void getRemainingSeats(){
        assertEquals(6, flight.getRemainingSeats());
    }

    @Test
    public void canBookPassenger(){
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    public void cannotAddIfPlaneIsFull(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        assertEquals(6, flight.getNumberOfPassengers());
    }

}
