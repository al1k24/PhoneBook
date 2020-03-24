package alik.master.service;

import alik.master.model.ContactModel;
import alik.master.model.PhoneBookModel;

import java.util.Scanner;

public class PhoneBook extends PhoneBookModel {

    static {
        contacts.put(++id, new ContactModel("Илюха", "Сеньор", "777"));
        contacts.put(++id, new ContactModel("Витя", "Джуниор", "000"));
        contacts.put(++id, new ContactModel("Алик", "Ученик", "444"));
    }

    public static void start() {
        System.out.println("* Введи /help, если у вас есть вопросы!");

        String cmd;
        do {
            Scanner input = new Scanner(System.in);

            Command.executeCommand((cmd = input.next()));
        } while (!Command.isExitCommand(cmd));
    }

    public static boolean addContact(String name, String surname, String phone) {
        if (name.isEmpty() || surname.isEmpty() || phone.isEmpty())
            return false;

        contacts.put(++id, new ContactModel(name, surname, phone));

        return true;
    }

    public static boolean removeContact(int id) {
        return contacts.remove(id) != null;
    }

    public static boolean editContact(int id, int choice, String value) {
        if (value.isEmpty())
            return false;

        ContactModel contact = contacts.get(id);
        switch (choice) {
            case 1:
                contact.setName(value);
                break;
            case 2:
                contact.setSurname(value);
                break;
            case 3:
                contact.setPhone(value);
                break;
        }

        contacts.put(id, contact);

        return true;
    }

    public static boolean isValidContact(int id) {
        return contacts.containsKey(id);
    }
}