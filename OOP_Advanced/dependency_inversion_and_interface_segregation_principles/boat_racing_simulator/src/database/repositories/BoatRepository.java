package database.repositories;

import Utility.Constants;
import contracts.Boat;
import contracts.CrudRepository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;


import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository implements CrudRepository<Boat> {
    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new LinkedHashMap<>();
    }

    @Override
    public Boat findByModel(String model) throws NonExistantModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }
        return this.boats.get(model);
    }

    @Override
    public void add(Boat item) throws DuplicateModelException {
        if (this.boats.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.boats.put(item.getModel(), item);
    }

    @Override
    public Boat getItem(String model) throws NonExistantModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }
        return this.boats.get(model);
    }

}
