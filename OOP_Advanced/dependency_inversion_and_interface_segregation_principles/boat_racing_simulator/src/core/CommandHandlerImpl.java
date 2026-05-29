package core;

import annotation.Inject;
import contracts.BoatSimulatorController;
import contracts.Executable;
import exeptions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CommandHandlerImpl implements contracts.CommandHandler {
    private final String COMMAND_CLASS_PATH = "core.commands.";
    public static final String COMMAND_CLASS_NAME_SUFFIX = "Command";
    private List<String> params;
    private BoatSimulatorController controller;

    public CommandHandlerImpl(BoatSimulatorController controller) {
        this.controller = controller;
    }

    public String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        this.params = parameters;
        Class<?> commandClass = Class.forName(COMMAND_CLASS_PATH + name + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<?> constructor = commandClass.getDeclaredConstructor();
        Executable command = (Executable) constructor.newInstance();
        injectDependencies(command);
        String result = command.execute();
        return result;
    }
    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] commandFields = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    if (commandField.getType().isAssignableFrom(engineField.getType())) {
                        commandField.setAccessible(true);
                        engineField.setAccessible(true);

                        Object valueToInject = engineField.get(this);
                        commandField.set(executable, valueToInject);
                    }
                }
            }
        }
    }
}

