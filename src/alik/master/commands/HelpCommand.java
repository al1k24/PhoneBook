package alik.master.commands;

import java.util.Map;

import static alik.master.model.CommandModel.getCommandsDescription;

public class HelpCommand implements CommandExecution {

    @Override
    public void execute() {
        System.out.println("Доступные команды:");

        Map<String, String> helpCommand = getCommandsDescription();
        helpCommand.forEach((command, description) -> System.out.println(command + " " + description));
    }
}
