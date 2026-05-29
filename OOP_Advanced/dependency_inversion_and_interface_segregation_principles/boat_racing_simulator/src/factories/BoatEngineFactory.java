package factories;

import contracts.BoatEngine;
import models.boats_engine.JetEngine;
import models.boats_engine.SterndriveEngine;

public final class BoatEngineFactory {
    private BoatEngineFactory() {

    }

    public static BoatEngine createJetEngine(String model, int horsepower, int displacement) {
        return new JetEngine(model,  horsepower, displacement);
    }

    public static BoatEngine createSternDriveEngine(String model, int horsepower, int displacement) {
        return new SterndriveEngine(model,  horsepower, displacement);
    }
}
