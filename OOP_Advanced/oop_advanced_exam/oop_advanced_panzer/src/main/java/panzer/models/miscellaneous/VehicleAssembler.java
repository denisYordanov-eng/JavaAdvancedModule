package panzer.models.miscellaneous;

import panzer.contracts.Assembler;
import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VehicleAssembler implements Assembler {
    private List<Part> arsenalParts;

    private List<Part> shellParts;

    private List<Part> enduranceParts;

    public VehicleAssembler() {
        this.arsenalParts = new ArrayList<>();
        this.shellParts = new ArrayList<>();
        this.enduranceParts = new ArrayList<>();
    }

    @Override
    public double getTotalWeight() {
        return this.arsenalParts.stream().mapToDouble(Part::getWeight).sum()
                + this.shellParts.stream().mapToDouble(Part::getWeight).sum()
                + this.enduranceParts.stream().mapToDouble(Part::getWeight).sum();
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal arsenalPrice = this.arsenalParts.stream()
                .map(Part::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal shellPrice = this.shellParts.stream()
                .map(Part::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal endurancePrice = this.enduranceParts.stream()
                .map(Part::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return arsenalPrice.add(shellPrice).add(endurancePrice);
    }

    @Override
    public long getTotalAttackModification() {
        return this.arsenalParts.stream()
                .mapToLong(part -> {
                    try {
                        Object result = part.getClass().getMethod("getAttackModifier").invoke(part);
                        return ((Number) result).longValue();
                    } catch (Exception e) {
                        return 0L;
                    }
                })
                .sum();
    }

    @Override
    public long getTotalDefenseModification() {
        return this.shellParts.stream()
                .mapToLong(part -> {
                    try {
                        Object result = part.getClass().getMethod("getDefenseModifier").invoke(part);
                        return ((Number) result).longValue();
                    } catch (Exception e) {
                        return 0L;
                    }
                })
                .sum();
    }

    @Override
    public long getTotalHitPointModification() {
        return this.enduranceParts.stream()
                .mapToLong(part -> {
                    try {
                        Object result = part.getClass().getMethod("getHitPointsModifier").invoke(part);
                        return ((Number) result).longValue();
                    } catch (Exception e) {
                        return 0L;
                    }
                })
                .sum();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        if (arsenalPart == null) {
            throw new NullPointerException("arsenalPart cannot be null");
        }
        this.arsenalParts.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        if (shellPart == null) {
            throw new NullPointerException("ShellPart cannot be null");
        }
        this.shellParts.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        if (endurancePart == null) {
            throw new NullPointerException("endurance part cannot be null");
        }
        this.enduranceParts.add(endurancePart);
    }
}