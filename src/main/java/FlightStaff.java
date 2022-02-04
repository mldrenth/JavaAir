public abstract class FlightStaff {
    private String name;
    private RankType rank;

    public FlightStaff(String name, RankType rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public RankType getRank() {
        return rank;
    }
}
