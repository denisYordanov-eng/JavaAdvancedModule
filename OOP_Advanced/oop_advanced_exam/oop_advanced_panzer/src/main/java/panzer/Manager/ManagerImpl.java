package panzer.manager;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.entities.parts.ArsenalPart;
import panzer.entities.parts.EndurancePart;
import panzer.entities.parts.ShellPart;
import panzer.entities.vehicles.Revenger;
import panzer.entities.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {
    private Map<String, Vehicle> vehicles;
    private Map<String, Part> availableParts;
    private Map<String, Vehicle> defeatedVehicles;
    private BattleOperator battleOperator;

    public ManagerImpl() {
        this.vehicles = new LinkedHashMap<>();
        this.availableParts = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedHashMap<>();
        this.battleOperator = new PanzerBattleOperator();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        //•	Vehicle {vehicleType} {model} {weight} {price} {attack} {defense} {hitPoints}
        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int attack = Integer.parseInt(arguments.get(5));
        int defense = Integer.parseInt(arguments.get(6));
        int hitPoints = Integer.parseInt(arguments.get(7));

        if (type.equalsIgnoreCase("Vanguard")) {
            Vehicle vanguardVehicle = new Vanguard(model, weight, price, attack, defense, hitPoints);
            this.vehicles.put(model, vanguardVehicle);
        } else if (type.equalsIgnoreCase("Revenger")) {
            Vehicle revenger = new Revenger(model, weight, price, attack, defense, hitPoints);
            this.vehicles.put(model, revenger);
        }
        return String.format("Created %s Vehicle - %s", type, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        //•	Part {vehicleModel} {partType} {model} {weight} {price} {additionalParameter}
        String vehicleModel = arguments.get(1);
        String partType = arguments.get(2);
        String model = arguments.get(3);
        double weight = Double.parseDouble(arguments.get(4));
        BigDecimal price = new BigDecimal(arguments.get(5));
        Part part = null;
        switch (partType) {
            case "Arsenal":
                int attackModifier = Integer.parseInt(arguments.get(6));
                part = new ArsenalPart(model, weight, price, attackModifier);
                this.vehicles.get(vehicleModel).addArsenalPart(part);
                break;
            case "Endurance":
                int hitPartsModifier = Integer.parseInt(arguments.get(6));
                part = new EndurancePart(model, weight, price, hitPartsModifier);
                this.vehicles.get(vehicleModel).addEndurancePart(part);
                break;
            case "Shell":
                int defenceModifier = Integer.parseInt(arguments.get(6));
                part = new ShellPart(model, weight, price, defenceModifier);
                this.vehicles.get(vehicleModel).addShellPart(part);
        }
        if (part != null) {
            this.availableParts.put(model, part);
            return String.format("Added %s - %s to Vehicle - %s",
                    partType, model, vehicleModel);
        }
        return null;
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(1);
        if (this.vehicles.containsKey(model)) {
            return this.vehicles.get(model).toString();
        } else if (this.availableParts.containsKey(model)) {
            return this.availableParts.get(model).toString();
        }
        return "";
    }

    @Override
    public String battle(List<String> arguments) {
        //Battle {vehicle1Model} {vehicle2Model}
        Vehicle firstVehicle = this.vehicles.get(arguments.get(1));
        Vehicle secondVehicle = this.vehicles.get(arguments.get(2));

        String winnerModel = this.battleOperator.battle(firstVehicle, secondVehicle);

        if (winnerModel.equalsIgnoreCase(firstVehicle.getModel())) {
            this.defeatedVehicles.put(secondVehicle.getModel(), secondVehicle);
            this.vehicles.remove(secondVehicle.getModel());
        } else if (winnerModel.equalsIgnoreCase(secondVehicle.getModel())) {
            this.defeatedVehicles.put(firstVehicle.getModel(), firstVehicle);
            this.vehicles.remove(firstVehicle.getModel());
        }
        return String.format("%s versus %s -> %s Wins! Flawless Victory!"
                , firstVehicle.getModel()
                , secondVehicle.getModel()
                , winnerModel);
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        //Remaining Vehicles: {vehicle1Model}, {vehicle2Model}...
        //Defeated Vehicles: {defeatedVehicle1Model}, {defeatedVehicle2Model}...
        //Currently Used Parts: {countOfCurrentlyUsedParts}
        sb.append("Remaining Vehicles: ");
        if (vehicles.isEmpty()) {
            sb.append("None");
        } else {
            String remainingOutput = String.join(", ", this.vehicles.keySet());
            sb.append(remainingOutput);
        }

        sb.append(System.lineSeparator());

        sb.append("Defeated Vehicles: ");
        if (this.defeatedVehicles.isEmpty()) {
            sb.append("None");
        } else {
            String defeatedVehicles = String.join(", ", this.defeatedVehicles.keySet());
            sb.append(defeatedVehicles);
        }

        sb.append(System.lineSeparator());

        sb.append("Currently Used Parts: ");
        long partsCounter = 0;
        for (Vehicle vehicle : this.vehicles.values()) {
            for (Part part : vehicle.getParts()) {
                partsCounter++;
            }
        }

        sb.append(partsCounter);
        sb.append(System.lineSeparator());
        return sb.toString().trim();
    }
}
