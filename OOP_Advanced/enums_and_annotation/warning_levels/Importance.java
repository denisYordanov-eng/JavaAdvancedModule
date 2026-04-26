package warning_levels;

public enum Importance {
    LOW(1), NORMAL(2), MEDIUM(3), HIGH(4);
    private int value;

    Importance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
