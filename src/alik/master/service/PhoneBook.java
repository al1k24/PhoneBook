package alik.master.service;

import alik.master.model.ContactModel;
import alik.master.model.PhoneBookModel;

import java.util.Scanner;

public class PhoneBookService extends PhoneBookModel {

    static {
        contacts.put(++id, new ContactModel("Илюха", "Сеньор", "777"));
        contacts.put(++id, new ContactModel("Витя", "Джуниор", "000"));
        contacts.put(++id, new ContactModel("Алик", "Ученик", "444"));
    }

    public static void start() {
        System.out.println("Введи команду:");

        String cmd;
        do {
            Scanner input = new Scanner(System.in);

            CommandService.executeCommand((cmd = input.next()));
        } while (!CommandService.isExitCommand(cmd));
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

    public static boolean isValidContact(int id) {
        return contacts.containsKey(id);
    }
}