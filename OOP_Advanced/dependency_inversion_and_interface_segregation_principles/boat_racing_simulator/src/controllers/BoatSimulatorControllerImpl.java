package controllers;

import Utility.Constants;
import contracts.Boat;

import contracts.BoatEngine;
import contracts.DataBase;
import contracts.Race;
import database.repositories.boatSimulatorDatabase;

import exeptions.*;
import factories.BoatEngineFactory;
import factories.BoatFactory;
import factories.RaceFactory;


import java.util.*;


public class BoatSimulatorControllerImpl implements contracts.BoatSimulatorController {
    private static final String[] POSITIONS = {"First", "Second", "Third"};

    private DataBase database;
    private Race currentRace;

    public BoatSimulatorControllerImpl(DataBase database) {
        this.database = database;
    }

    @Override
    public Race getCurrentRace() {
        return null;
    }

    @Override
    public boatSimulatorDatabase getDatabase() {
        return null;
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = BoatFactory.createRowBoat(model, weight, oars);

        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }


    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().findByModel(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().findByModel(secondEngineModel);
        Boat boat = BoatFactory.createPowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().findByModel(engineModel);
        Boat boat = BoatFactory.createYacht(model, weight, engine, cargoWeight);
        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = BoatFactory.createSailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }


    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = RaceFactory.createRace(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    @Override
    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().findByModel(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat.hasEngine()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<Boat> participants = this.currentRace.getParticipants();

        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        Comparator<Boat> timeComparator = (boat1, boat2) -> {
            double speedBoat1 =  boat1.calculateRaceSpeed(this.currentRace);

            double speedBoat2 =  boat2.calculateRaceSpeed(this.currentRace);
            if (speedBoat1 < 0 && speedBoat2 < 0) {
                return 0;
            }
            return Double.compare(speedBoat2, speedBoat1);
        };

        participants.sort(timeComparator);
        StringBuilder sb = new StringBuilder();

        final int[] pos = {0};
        participants.stream().limit(3).forEach(
                participant -> {
                    sb.append(String.format("%s: %s: %s Time: %s"
                                    , POSITIONS[pos[0]++]
                                    , participant.getClass().getSimpleName()
                                    , participant.getModel()
                                    , (currentRace.getDistance() / participant.calculateRaceSpeed(this.currentRace)) <= 0.0 ?
                                            "Did not finish!" :
                                            String.format("%.2f sec", currentRace.getDistance() / participant.calculateRaceSpeed(this.currentRace))))
                            .append(System.lineSeparator());
                });
            this.currentRace = null;
        return sb.toString().trim();
    }

    @Override
    public String getStatistic() {
        return "";
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType) throws DuplicateModelException {
        BoatEngine engine = null;
        switch (engineType) {
            case "Jet":
                engine = BoatEngineFactory.createJetEngine(model, horsepower, displacement);
                break;
            case "Sterndrive":
                engine = BoatEngineFactory.createSternDriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}

