public class Pilot extends FlightStaff{

    private String pilotLicenceNumber;


    public Pilot(String name, RankType rank, String pilotLicenceNumber) {
        super(name, rank);
        this.pilotLicenceNumber = pilotLicenceNumber;
    }

    public String getPilotLicenceNumber() {
        return pilotLicenceNumber;
    }

    public String fly(){
        return "I am flying the plane!";
    }
}
