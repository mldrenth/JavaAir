import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PassengerTest {

    private Passenger passenger;
    private Flight flight;
    private Pilot  pilot;
    private CabinCrewMember flightAttendant1;
    private CabinCrewMember flightAttendant2;
    private Plane plane;
    private ArrayList<Pilot> pilotList;
    private ArrayList<CabinCrewMember> cabinCrewList;
    private Date date;
    private ArrayList<Integer> remainingSeatNumbers;

    @Before
    public void before(){
        passenger = new Passenger("Bob", 2);
        pilot = new Pilot("Bill", RankType.CAPTAIN, "ABC1");
        flightAttendant1 = new CabinCrewMember("Anna", RankType.FLIGHTATTENDANT);
        flightAttendant2 = new CabinCrewMember("Bob", RankType.FLIGHTATTENDANT);
        pilotList = new ArrayList<>(Arrays.asList(pilot));
        cabinCrewList = new ArrayList<>(Arrays.asList(flightAttendant1, flightAttendant2));
        plane = new Plane(PlaneType.TWINTURBOPROPS);
        date = new Date(1639739100000L);
        flight = new Flight(pilotList, cabinCrewList, plane, "FR756", "EDI", "MUC", date);
    }

    @Test
    public void hasName(){
        assertEquals("Bob", passenger.getName());
    }

    @Test
    public void hasNumberOfBags(){
        assertEquals(2, passenger.getNumberOfBags());
    }

    @Test
    public void flightIsNullAtStart(){
        assertEquals(false, passenger.hasFlight());
    }

    @Test
    public void passengerHasFlightAfterBookedIn(){
        flight.bookPassenger(passenger);
        assertEquals(true, passenger.hasFlight());
    }

    @Test
    public void seatNumber0AtStart(){
        assertEquals(0, passenger.getSeatNumber());
    }

    @Test
    public void hasSeatNumberAfterBooked(){
        flight.bookPassenger(passenger);
        int seatNumber = passenger.getSeatNumber();
        int capacity = flight.getPlane().getPlaneType().getCapacity();
        assertTrue(1 <= seatNumber && seatNumber <= capacity );
    }


}
