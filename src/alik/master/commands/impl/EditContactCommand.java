package alik.master.commands.impl;

import alik.master.commands.CommandExecution;
import alik.master.service.PhoneBookService;

import java.util.Scanner;

public class EditContactCommand implements CommandExecution {

    @Override
    public void execute() {
        System.out.print("Редактировать пользователя с айди - ");

        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()) {
            System.out.println("* Введите целочисленное значение!");
            return;
        }

        int id = input.nextInt();

        if (!PhoneBookService.isValidContact(id)) {
            System.out.println("* Такой контакт не найден!");
            return;
        }

        String menu = "Выберите действие:\n";
        menu += "1: Изменить имя\n";
        menu += "2: Изменить фамилию\n";
        menu += "3: Изменить мобильный\n";
        menu += "0: Выход\n";
        System.out.println(menu);

        System.out.print("Мой выбор - ");

        input = new Scanner(System.in);
        if (!input.hasNextInt()) {
            System.out.println("* Введите целочисленное значение!");
            return;
        }

        int choice = input.nextInt();
        if (choice == 0) {
            System.out.println("* Редактирование отменено!");
            return;
        }

        if (choice < 1 || choice > 3) {
            System.out.println("* Выберите правильное значение!");
            return;
        }

        System.out.print("Новое значение - ");

        input = new Scanner(System.in);

        if (PhoneBookService.editContact(id, choice, input.next())) {
            System.out.println("* Контакт изменен.");
        } else {
            System.out.println("* Что-то пошло не так!");
        }
    }
}
