import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Flight {

    private ArrayList<Pilot> pilotList;
    private ArrayList<CabinCrewMember> cabinCrewList;
    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private Date departureTime;
    private List<Integer> remainingSeatNumbers;



    public Flight(ArrayList<Pilot> pilotList, ArrayList<CabinCrewMember> cabinCrewList, Plane plane, String flightNumber, String destination, String departureAirport, Date departureTime) {
        this.pilotList = pilotList;
        this.cabinCrewList = cabinCrewList;
        this.passengerList = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.remainingSeatNumbers = IntStream.range(1, this.plane.getPlaneType().getCapacity() +1).boxed().collect(Collectors.toList());
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

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public List<Integer> getRemainingSeatNumbers() {
        return this.remainingSeatNumbers;
    }


    public int getRemainingSeats() {
        return this.remainingSeatNumbers.size();
    }

    public boolean hasEmptySeats(){
        return this.getRemainingSeats() > 0;
    }

    public void bookPassenger(Passenger passenger) {
        if (hasEmptySeats()) {
        this.passengerList.add(passenger);
        passenger.setFlight(this);
        passenger.setSeatNumber(this.allocateSeatNumber());}
    }

    public int allocateSeatNumber() {
        int seatNumber = this.remainingSeatNumbers.get(new Random().nextInt(remainingSeatNumbers.size()));
        int indexOfSeat = this.remainingSeatNumbers.indexOf(seatNumber);
        this.remainingSeatNumbers.remove(indexOfSeat);
        return seatNumber;
    }
}
