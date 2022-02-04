import java.util.ArrayList;
import java.util.Arrays;

public class Flight {

    private ArrayList<Pilot> pilotList;
    private ArrayList<CabinCrewMember> cabinCrewList;
    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;


    public Flight(ArrayList<Pilot> pilotList, ArrayList<CabinCrewMember> cabinCrewList, Plane plane, String flightNumber, String destination, String departureAirport, String departureTime) {
        this.pilotList = pilotList;
        this.cabinCrewList = cabinCrewList;
        this.passengerList = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public int getNumberOfPilots() {
        return this.pilotList.size();
    }

    public int getNumberOfCabinCrew() {
        return this.cabinCrewList.size();
    }

    public int getNumberOfPassengers() {
        return this.passengerList.size();
    }

    public String getDestination() {
        return  this.destination;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }


    public int getRemainingSeats() {
        return (this.plane.getPlaneType().getCapacity() - this.getNumberOfPassengers());
    }

    public boolean hasEmptySeats(){
        return this.getRemainingSeats() > 0;
    }

    public void bookPassenger(Passenger passenger) {
        if (hasEmptySeats()) {
        this.passengerList.add(passenger);}
    }
}
