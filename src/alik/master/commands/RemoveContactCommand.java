package alik.master.commands;

import alik.master.service.PhoneBook;

import java.util.Scanner;

public class RemoveContactCommand implements CommandExecution {

    @Override
    public void execute() {
        System.out.print("Удалить пользователя с айди - ");

        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()) {
            System.out.println("* Введите целочисленное значение!");
            return;
        }

        if (PhoneBook.removeContact(input.nextInt())) {
            System.out.println("* Контакт удален.");
        } else {
            System.out.println("* Такой контакт не найден!");
        }
    }
}
