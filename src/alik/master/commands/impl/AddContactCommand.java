package alik.master.commands.impl;

import alik.master.commands.CommandExecution;
import alik.master.service.PhoneBookService;

import java.util.Scanner;

public class AddContactCommand implements CommandExecution {

    @Override
    public void execute() {
        String name, surname, phone;

        System.out.println("Добавление нового пользователя:");

        Scanner input = new Scanner(System.in);
        System.out.print("Введите имя - ");
        name = input.next();

        System.out.print("Введите фамилию - ");
        surname = input.next();

        System.out.print("Введите мобильный номер - ");
        phone = input.next();

        if (PhoneBookService.addContact(name, surname, phone)) {
            System.out.println("* Контакт добавлен.");
        } else {
            System.out.println("* Заполните все поля правильно!");
        }
    }
}
