package database.repositories;

import Utility.Constants;
import contracts.BoatEngine;
import contracts.CrudRepository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;



import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository  implements CrudRepository<BoatEngine> {
    private Map<String, BoatEngine> boatsEngines;

    public BoatEngineRepository() {
        this.boatsEngines = new LinkedHashMap<>();
    }

    @Override
    public BoatEngine findByModel(String model) throws NonExistantModelException {
        if(!this.boatsEngines.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }
        return this.boatsEngines.get(model);
    }

    @Override
    public void add(BoatEngine item) throws DuplicateModelException {
        if(boatsEngines.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.NonExistantModelMessage);
        }
        this.boatsEngines.put(item.getModel(), item);
    }

    @Override
    public BoatEngine getItem(String model) throws NonExistantModelException {
        if(!this.boatsEngines.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }
        return this.boatsEngines.get(model);
    }
}
