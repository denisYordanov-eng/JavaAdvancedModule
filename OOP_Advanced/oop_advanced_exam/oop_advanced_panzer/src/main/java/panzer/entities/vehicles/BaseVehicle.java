package panzer.entities.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseVehicle implements Vehicle {
    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler assembler;
    private List<Part> parts;

    protected BaseVehicle(String model, double weight, BigDecimal price
            , int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;

        this.assembler = new VehicleAssembler();
        this.parts = new ArrayList<>();
    }

//    protected abstract BigDecimal modifyPrice(BigDecimal price);
//
//    protected abstract double modifyWeight(double weight);
//
//    protected abstract int modifyAttack(int attack);
//
//    protected abstract int modifyDefense(int defense);
//
//    protected abstract int modifyHitPoints(int hitPoints);


    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getTotalWeight() {
        return this.weight + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return (this.price).add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return (long) (this.attack) + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return (long) (this.defense) + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return (long) (this.hitPoints) + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
        this.parts.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
        this.parts.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
        this.parts.add(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.parts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String vehicleType = this.getClass().getSimpleName();
        sb.append(String.format("%s - %s", vehicleType, this.getModel()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Total Weight: %.3f", this.getTotalWeight()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Total Price: %.3f", this.getTotalPrice().doubleValue()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Attack: %d", this.getTotalAttack()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Defense: %d", this.getTotalDefense()));
        sb.append(System.lineSeparator());
        sb.append(String.format("HitPoints: %d", this.getTotalHitPoints()));
        sb.append(System.lineSeparator());
        sb.append("Parts: ");
        List<String> partModels = new ArrayList<>();
        for (Part part : this.getParts()) {
            partModels.add(part.getModel());
        }
        String partsOutput = String.join(", ", partModels);
        sb.append(partsOutput);
        return sb.toString().trim();
    }
}
