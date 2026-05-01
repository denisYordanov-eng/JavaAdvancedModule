package enumerations_and_annotations.traffic_lights;

public enum TrafficLight {
    RED,
    GREEN,
    YELLOW;

    public TrafficLight getNextTrafficLight() {
        switch (this) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
        }
        return RED;
    }
}
