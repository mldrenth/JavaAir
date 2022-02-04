import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight flight;
    private Pilot pilot;
    private CabinCrewMember flightAttendant1;
    private CabinCrewMember flightAttendant2;
    private Passenger passenger;
    private Plane plane;
    private ArrayList<Pilot> pilotList;
    private ArrayList<CabinCrewMember> cabinCrewList;
    private Date date;

    @Before
    public void before() {
        passenger = new Passenger("Paul", 2);
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
    public void has1Pilot() {
        assertEquals(1, flight.getNumberOfPilots());
    }

    @Test
    public void has2CabinCrew() {
        assertEquals(2, flight.getNumberOfCabinCrew());

    }

    @Test
    public void hasEmptyPassengerList() {
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("FR756", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("EDI", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("MUC", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals("Fri Dec 17 13:05:00 EET 2021", flight.getDepartureTime().toString());
    }

    @Test
    public void getRemainingSeats() {
        assertEquals(6, flight.getRemainingSeats());
    }

    @Test
    public void canBookPassenger() {
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    public void cannotAddIfPlaneIsFull() {
        Passenger passenger2 = new Passenger("Bill", 0);
        Passenger passenger3 = new Passenger("Bill2", 0);
        Passenger passenger4 = new Passenger("Bill3", 0);
        Passenger passenger5 = new Passenger("Bill4", 0);
        Passenger passenger6 = new Passenger("Bill5", 0);
        Passenger passenger7 = new Passenger("Bill6", 0);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        flight.bookPassenger(passenger5);
        flight.bookPassenger(passenger6);
        flight.bookPassenger(passenger7);
        assertEquals(6, flight.getNumberOfPassengers());
    }

    @Test
    public void canAllocateSeatNumber() {
        int seatNumber = flight.allocateSeatNumber();
        int capacity = flight.getPlane().getPlaneType().getCapacity();
        System.out.println(seatNumber);
        assertTrue(1 <= seatNumber && seatNumber <= capacity);
    }

    @Test
    public void cannotAllocateTakenSeatNumber() {
        flight.bookPassenger(passenger);
        int takenNumber = passenger.getSeatNumber();
        assertFalse(flight.getRemainingSeatNumbers().contains(takenNumber));
    }


}
