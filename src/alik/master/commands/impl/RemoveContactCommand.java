package alik.master.commands.impl;

import alik.master.commands.CommandExecution;
import alik.master.service.DataBaseService;

import java.sql.SQLException;
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

        try {
            DataBaseService dbs = new DataBaseService();
            if (dbs.removeContact(input.nextInt())) {
                System.out.println("* Контакт удален.");
            } else {
                System.out.println("* Такой контакт не найден!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
