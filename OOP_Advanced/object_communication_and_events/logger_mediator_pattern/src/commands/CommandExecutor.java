package commands;

import interfaces.Command;
import interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void execute(Command command) {
        command.execute();
    }
}
