package alik.master;

import java.util.Scanner;

import static alik.master.EditType.*;

public class App {

    PhoneBook book = new PhoneBook(true);

    public void start() {
        showStartMessage();

        String command;
        do {
            Scanner input = new Scanner(System.in);

            command = input.next();

            if(Command.isValid(command)) {
                executeCommand(command);
            }
        } while (!Command.isExit(command));

        showEndMessage();
    }

    private void executeCommand(String cmd) {
        if (cmd.equals(Command.HELP.getValue())) {
            commandHelp();
        } else if (cmd.equals(Command.USER_ADD.getValue())) {
            commandAddUser();
        } else if (cmd.equals(Command.USER_EDIT.getValue())) {
            commandEditUser();
        } else if (cmd.equals(Command.USER_REMOVE.getValue())) {
            commandRemoveUser();
        } else if (cmd.equals(Command.USERS_LIST.getValue())) {
            commandAllUsers();
        }
    }

    private void commandHelp() {
        System.out.println("Доступные команды:");

        String[][] commands = new String[][] {
            {"/user_add", "- Добавляет новый контакт"},
            {"/user_edit", "- Изменяет существующий контакт"},
            {"/user_remove", "- Удаляет существующий контакт"},

            {"/users_list", "- Выводит список всех контактов"},

            {"/exit", "- Выход из программы"}
        };

        for(String[] command:commands) {
            if(Command.isValid(command[0])) {
                System.out.println(command[0] + " " + command[1]);
            }
        }
    }

    private void commandAddUser() {
        String name, surname, phone;

        System.out.println("Добавление нового пользователя:");

        Scanner input = new Scanner(System.in);
        System.out.print("Введите имя - ");
        name = input.next();

        System.out.print("Введите фамилию - ");
        surname = input.next();

        System.out.print("Введите мобильный номер - ");
        phone = input.next();

        if(book.addUser(name, surname, phone)) {
            System.out.println("Вы добавили - " + name + " " + surname + " (tel: " + phone + ")");
        } else {
            System.out.println("Ошибка: * Упс, попробуйте ещё раз.");
        }
    }

    private void commandRemoveUser() {
        System.out.print("Удалить пользователя с айди = ");

        int id = scanAndGetUserId();

        if(!(book.removeUser(id))) {
            System.out.println("Ошибка: * Такой контакт не найден.");
        } else {
            System.out.println("* Пользователь удалён.");
        }
    }

    private void commandEditUser() {
        System.out.print("Редактировать пользователя с айди = ");

        int id = scanAndGetUserId();
        if(!book.hasUser(id)) {
            System.out.println("Ошибка: * Такой контакт не найден."); return;
        }

        System.out.println("Вы выбрали: " + book.showUser(id));

        EditType.showInfo();
        EditType editType = scanAndGetEditType();

        if(editType != ET_NONE) {
            String input = scanAndGetEditedInput(editType);

            if(!(book.editUser(id, editType, input))) {
                System.out.println("Ошибка: * Упс, попробуйте ещё раз.");
            } else {
                System.out.println("Данные контакта были обновлены.");
            }
        }
    }

    public void commandAllUsers() {
        book.showAllUsers();
    }

    private void showStartMessage() {
        System.out.println("Добро пожаловать в телефонный справочник.");
        System.out.println("Введите /help, если у вас есть вопросы.");
    }

    private void showEndMessage() {
        System.out.println("Спасибо за использование нашего телефонного справочника!");
    }

    private int scanAndGetUserId() {
        Scanner input = new Scanner(System.in);

        return input.hasNextInt() ? input.nextInt() : 0;
    }

    private EditType scanAndGetEditType() {
        EditType editType = ET_NONE;

        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()) {
            int type = input.nextInt();

            editType = getEditType(type);
        }

        return editType;
    }

    private String scanAndGetEditedInput(EditType type) {
        System.out.print("Новое значение = ");

        Scanner input = new Scanner(System.in);

        return input.hasNext() ? input.next() : "";
    }
}
