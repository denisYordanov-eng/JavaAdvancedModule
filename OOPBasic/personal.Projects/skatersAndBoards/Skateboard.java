package DefiningClass_Exercises.skatersAndBoards;

class Skateboard {
    private String deckBrand;
    private double deckSize;

    private String truckBrand;
    private int truckSize;

    private String wheelsBrand;
    private int wheelsSize;

    private String bearingsBrand;


    Skateboard(String deckBrand, double deckSize, String truckBrand, int truckSize, String wheelsBrand, int wheelsSize, String bearingsBrand) {
        this.deckBrand = deckBrand;
        this.deckSize = deckSize;
        this.truckBrand = truckBrand;
        this.truckSize = truckSize;
        this.wheelsBrand = wheelsBrand;
        this.wheelsSize = wheelsSize;
        this.bearingsBrand = bearingsBrand;
    }

    public String getDeckBrand() {
        return deckBrand;
    }

    public double getDeckSize() {
        return deckSize;
    }

    void breakDeck() {
        this.deckBrand = null;
        this.deckSize = 0;
    }

    void buyDeck(String deckBrand, double deckSize) {
        this.deckBrand = deckBrand;
        this.deckSize = deckSize;
    }

    @Override
    public String toString() {
        return String.format("Deck: %s %.2f%n" +
                "Trucks: %s %d%n" +
                "Wheels: %s %d%n" +
                "Bearings: %s%n", this.deckBrand, this.deckSize, this.truckBrand, this.truckSize, this.wheelsBrand, this.wheelsSize, this.bearingsBrand);
    }
}
