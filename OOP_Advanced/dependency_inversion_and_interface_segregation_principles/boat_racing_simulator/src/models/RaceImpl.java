package models;

import Utility.Constants;
import Utility.Validator;
import contracts.Boat;
import exeptions.DuplicateModelException;

import java.util.*;

public class RaceImpl implements contracts.Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Map<String, Boat> registeredBoats;
    private boolean allowsMotorBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    @Override
    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }
    @Override
    public boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }
}