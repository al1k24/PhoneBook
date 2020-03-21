package alik.master;

import java.util.Arrays;

public enum Command {

    USER_ADD("/user_add"),
    USER_EDIT("/user_edit"),
    USER_REMOVE("/user_remove"),

    USERS_LIST("/users_list"),

    HELP("/help"),
    EXIT("/exit");

    private String cmd;

    Command(String cmd) {
        this.cmd = cmd;
    }

    public static boolean isExit(String cmd) {
        return cmd.equals(EXIT.getValue());
    }

    public static boolean isValid(String cmd) {
        return Arrays.stream(Command.values()).
                anyMatch(command -> cmd.equals(command.getValue()));
    }

    public String getValue() {
        return cmd;
    }
}
