import java.util.ArrayList;

public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight){
        this.flight = flight;

    }


    public Flight getFlight() {
        return flight;
    }

    public double calcReservedWeight() {
        return this.flight.getPlane().getPlaneType().getTotalWeight() / 2.00;
    }

    public double calcSingleBaggageWeight() {
        return this.calcReservedWeight() / this.flight.getPlane().getPlaneType().getCapacity();
    }

    public double calcTotalBaggageWeight() {
        double totalWeight = 0;
        ArrayList<Passenger> passengerList = new ArrayList<>(this.flight.getPassengerList());
        for (Passenger passenger : passengerList) {
            totalWeight += passenger.numberOfBags * this.calcSingleBaggageWeight();

        }
        return totalWeight;
    }

    public double calcRemainingWeight() {
        return this.calcReservedWeight() - this.calcTotalBaggageWeight();
    }
}
