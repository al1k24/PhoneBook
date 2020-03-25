package alik.master.commands.impl;

import alik.master.commands.CommandExecution;
import alik.master.model.Contact;
import alik.master.service.DataBaseService;
import alik.master.service.PhoneBookService;

import java.sql.SQLException;
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

        try {
            DataBaseService dbs = new DataBaseService();
            if (dbs.addContact(new Contact(name, surname, phone))) {
                System.out.println("* Контакт добавлен.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
