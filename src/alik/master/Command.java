package alik.master;

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

    public String getValue() {
        return cmd;
    }

    public static boolean isExit(String cmd) {
        return cmd.equals(EXIT.getValue());
    }

    public static boolean isValid(String cmd) {
        char firstElement = cmd.charAt(0);

        if(firstElement != '/')
            return false;

        for(Command c:Command.values()) {
            if(c.getValue().equals(cmd)) {
                return true;
            }
        }

        return false;
    }
}
