public enum PlaneType {
    BOEING474(524,412769),
    AIRBUS380(853, 575000 ),
    EMBRAER175(88, 38790 ),
    TWINTURBOPROPS(6, 6531),
    TESTPLANE(6, 50);

    private final int capacity;
    private final int totalWeight;
    PlaneType(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
