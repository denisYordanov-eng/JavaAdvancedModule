package contracts;

public interface DataBase {
    CrudRepository<Boat> getBoats();

    CrudRepository<BoatEngine> getEngines();
}
