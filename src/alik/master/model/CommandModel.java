package alik.master.model;

import alik.master.commands.CommandExecution;

import java.util.HashMap;
import java.util.Map;

public class CommandModel {

    protected static final String EXIT_COMMAND = "/exit";

    protected static final Map<String, String> commandsDescription = new HashMap<>();
    protected static final Map<String, CommandExecution> commandsExecution = new HashMap<>();

    public static Map<String, String> getCommandsDescription() {
        return commandsDescription;
    }
}
