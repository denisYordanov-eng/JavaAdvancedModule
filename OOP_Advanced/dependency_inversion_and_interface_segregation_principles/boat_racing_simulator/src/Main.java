import core.CommandHandlerImpl;
import engines.Engine;
import contracts.*;
import controllers.BoatSimulatorControllerImpl;
import database.repositories.BoatEngineRepository;
import database.repositories.BoatRepository;
import database.repositories.boatSimulatorDatabase;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;

import java.lang.Runnable;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        CrudRepository<Boat> boatCrudRepository = new BoatRepository();
        CrudRepository<BoatEngine> boatEnginesCrudRepository = new BoatEngineRepository();
        DataBase dataBase = new boatSimulatorDatabase(boatCrudRepository, boatEnginesCrudRepository);
        BoatSimulatorController controller = new BoatSimulatorControllerImpl(dataBase);
        CommandHandler handler = new CommandHandlerImpl(controller);
        Runnable engine = new Engine(handler, reader, writer);

        engine.run();
    }
}
