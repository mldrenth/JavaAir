public class CabinCrewMember extends FlightStaff {


    public CabinCrewMember(String name, RankType rank) {
        super(name, rank);
    }

    public String relayMessage() {
        return "What would you like for lunch?";
    }
}
