package alik.master.commands;

public class AddUserCommand implements CommandExecution {
    @Override
    public void execute() {
        System.out.println("CommandAddUserExecuted");
    }
}
