package database.repositories;

import contracts.*;



public class boatSimulatorDatabase implements DataBase{
    private CrudRepository<Boat> boats;
    private CrudRepository<BoatEngine> engines;

    public boatSimulatorDatabase(CrudRepository<Boat> boats, CrudRepository<BoatEngine> engines) {
        this.boats = boats;
        this.engines = engines;
    }

    @Override
    public CrudRepository<Boat> getBoats() {
        return this.boats;
    }


    @Override
    public CrudRepository<BoatEngine> getEngines() {
        return this.engines;
    }
}
