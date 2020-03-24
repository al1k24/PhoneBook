package alik.master.commands.impl;

import alik.master.commands.CommandExecution;
import alik.master.service.CommandService;

import java.util.Map;

public class HelpCommand implements CommandExecution {

    @Override
    public void execute() {
        System.out.println("Доступные команды:");

        Map<String, String> helpCommand = CommandService.getCommandsDescription();
        helpCommand.forEach((command, description) -> System.out.println(command + " " + description));
    }
}
