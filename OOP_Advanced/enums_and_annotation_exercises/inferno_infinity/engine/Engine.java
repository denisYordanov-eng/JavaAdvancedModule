package inferno_infinity.engine;

import inferno_infinity.annotation.Inject;
import inferno_infinity.contracts.api.Weapon;
import inferno_infinity.core.commands.Executable;
import inferno_infinity.repositories.Repository;


import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;


public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "END";
    private static final String COMMAND_CLASS_PATH = "inferno_infinity.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private String[] params;
    private BufferedReader reader;
    private Repository<Weapon> repository;

    public Engine(BufferedReader reader, Repository<Weapon> repository) {
        //this.params = params;
        this.reader = reader;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {

            try {
                this.params = this.reader.readLine().split(";");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (TERMINATE_COMMAND.equals(this.params[0])) {
                break;
            }
            try {
                this.dispatchCommand(this.params[0], Arrays.stream(this.params).skip(1).toArray(String[]::new));
            } catch (ClassNotFoundException | IllegalArgumentException | InstantiationException |
                     IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void dispatchCommand(String command, String[] tokens) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> declaredConstructor = commandClass.getDeclaredConstructor();
        Executable executable = declaredConstructor.newInstance();
        injectionDependency(executable);
        executable.execute();
    }

    private void injectionDependency(Executable executable) throws InstantiationException, IllegalAccessException {
        Field[] commandFields = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    if(commandField.getType().isAssignableFrom(engineField.getType())) {
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

