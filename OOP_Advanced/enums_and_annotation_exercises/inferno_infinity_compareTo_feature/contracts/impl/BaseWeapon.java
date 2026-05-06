package inferno_infinity_compareTo_feature.contracts.impl;

import inferno_infinity_compareTo_feature.contracts.api.Weapon;
import inferno_infinity_compareTo_feature.enumerations.GemTypes;

import java.util.Arrays;
import java.util.stream.Collectors;


public abstract class BaseWeapon implements Weapon,Comparable<Weapon> {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int maxSockets;
    private GemTypes[] gems;
    private int bonusStrength;
    private int bonusAgility;
    private int bonusVitality;

    protected BaseWeapon(String name, int minDamage, int maxDamage, int maxSockets) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxSockets = maxSockets;

        this.gems = new GemTypes[this.maxSockets];
    }
    @Override
    public double getLevel() {
        int strength = 0;
        int agility = 0;
        int vitality = 0;

        for (GemTypes gemType : this.gems) {
            if (gemType != null) {
                strength += gemType.getStrength();
                agility += gemType.getAgility();
                vitality += gemType.getVitality();
            }
        }
        int currentMinDamage = this.minDamage + (strength * 2) + agility;
        int currentMaxDamage = this.maxDamage + (strength * 3) + (agility * 4);

        return(double) ((currentMaxDamage + currentMinDamage) / 2.0) + strength + agility + vitality;

    }
    @Override
    public int compareTo(Weapon other){
        return Double.compare(this.getLevel(),other.getLevel());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addGem(String gemType, int index) {
        if (index < 0 || index >= this.gems.length || !Arrays.stream(GemTypes.values()).map(GemTypes::name)
                .collect(Collectors.toList())
                .contains(gemType.toUpperCase())) {
            return;
        }
        this.gems[index] = GemTypes.valueOf(gemType.toUpperCase());
    }

    @Override
    public void removeGem(int index) {
        if (index < 0 || index >= this.gems.length || this.gems[index] == null) {
            return;
        }
        this.gems[index] = null;
    }

    @Override
    public String toString() {
        int strength = 0;
        int agility = 0;
        int vitality = 0;

        for (GemTypes gemType : this.gems) {
            if (gemType != null) {
                strength += gemType.getStrength();
                agility += gemType.getAgility();
                vitality += gemType.getVitality();
            }
        }
        int currentMinDamage = this.minDamage + (strength * 2) + agility;
        int currentMaxDamage = this.maxDamage + (strength * 3) + (agility * 4);


        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)", this.name, currentMinDamage
                , currentMaxDamage
                , strength
                , agility
                , vitality
                , this.getLevel());
    }
}