package core.commands;


import annotation.Inject;
import contracts.BoatSimulatorController;
import contracts.Executable;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable {
    @Inject
    private List<String> params;

    @Inject
    private BoatSimulatorController boatSimulatorController;

    protected BaseCommand() {

    }

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }
    protected BoatSimulatorController getBoatSimulatorController() {
        return this.boatSimulatorController;
    }
}
