package inferno_infinity_compareTo_feature.repositories;

import inferno_infinity_compareTo_feature.contracts.api.Weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponRepository<T extends  Weapon> implements Repository<Weapon>{
    private Map<String, Weapon> weapons;

    public WeaponRepository(){
        weapons = new HashMap<>();
    }

    @Override
    public void add(Weapon weapon) {
        if(weapon != null){
            this.weapons.putIfAbsent(weapon.getName(),weapon);
        }
    }

    @Override
    public Weapon get(String name) {
        return  this.weapons.get(name);
    }
}
