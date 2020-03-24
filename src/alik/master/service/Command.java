package alik.master.service;

import alik.master.commands.AddContactCommand;
import alik.master.commands.CommandExecution;
import alik.master.commands.ContactsListCommand;
import alik.master.commands.RemoveContactCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandService {

    public static final String EXIT_COMMAND = "/exit";

    private static final Map<String, String> commandsDescription = new HashMap<>();
    private static final Map<String, CommandExecution> commandsExecution = new HashMap<>();

    static {
        commandsDescription.put("/user_add", "- Добавляет новый контакт");
        commandsDescription.put("/user_edit", "- Изменяет существующий контакт");
        commandsDescription.put("/users_list", "- ");

        commandsExecution.put("/user_add", new AddContactCommand());
        commandsExecution.put("/user_remove", new RemoveContactCommand());
        commandsExecution.put("/users_list", new ContactsListCommand());
    }

    public static void executeCommand(String cmd) {
        if(isExitCommand(cmd)) return;;

        Optional.ofNullable(commandsExecution.get(cmd)).
                ifPresentOrElse((CommandExecution::execute), () -> System.out.println("Команда не найдена."));
    }

    public static boolean isExitCommand(String command) {
        return EXIT_COMMAND.equals(command);
    }
}
