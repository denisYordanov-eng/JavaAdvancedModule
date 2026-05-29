package engines;

import contracts.CommandHandler;
import contracts.InputReader;
import contracts.OutputWriter;
import exeptions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private final String TERMINATE_COMMAND = "End";
    private InputReader reader;
    private OutputWriter writer;
    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler, InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.commandHandler = commandHandler;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = Arrays.asList(this.reader.readLine().split("\\\\"));
            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }

            try {
                String result = this.commandHandler.executeCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
                System.out.println(result);

            } catch (DuplicateModelException | InsufficientContestantsException | RaceAlreadyExistsException |
                     NoSetRaceException | NonExistantModelException | ClassNotFoundException | NoSuchMethodException |
                     IllegalAccessException | InstantiationException | InvocationTargetException e) {
              this.writer.writeLine(e.getMessage());
            }
        }
    }
}
