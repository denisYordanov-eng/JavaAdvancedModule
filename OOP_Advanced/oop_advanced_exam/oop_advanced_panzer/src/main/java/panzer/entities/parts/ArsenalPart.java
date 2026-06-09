package panzer.entities.parts;


import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends BasePart implements AttackModifyingPart {
    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         sb.append(super.toString());
         sb.append(System.lineSeparator());
         sb.append(String.format("attackModifier %d",this.getAttackModifier()));
         return sb.toString().trim();
    }
}
