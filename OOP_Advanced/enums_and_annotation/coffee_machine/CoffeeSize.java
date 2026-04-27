package coffee_machine;

public enum CoffeeSize {
    SMALL (50, 50), NORMAL (100, 75), DOUBLE (200, 100);
    private int ml;
    private  int coin;

    CoffeeSize(int ml, int coin) {
        this.ml = ml;
        this.coin = coin;
    }

    public int getMl() {
        return this.ml;
    }

    public int getCoin() {
        return this.coin;
    }
    @Override
    public String toString()
    {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

}
