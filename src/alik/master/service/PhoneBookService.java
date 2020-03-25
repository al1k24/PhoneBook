package alik.master.service;

import alik.master.model.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookService {

    private static int id;

    private static final Map<Integer, Contact> contacts = new HashMap<>();

    public static Map<Integer, Contact> getContacts() {
        return contacts;
    }

    static {
        contacts.put(++id, new Contact("Илюха", "Сеньор", "777"));
        contacts.put(++id, new Contact("Витя", "Джуниор", "000"));
        contacts.put(++id, new Contact("Алик", "Ученик", "444"));
    }

    public static void start() {
        System.out.println("* Введи /help, если у вас есть вопросы!");

        String cmd;
        do {
            Scanner input = new Scanner(System.in);

            CommandService.executeCommand((cmd = input.next()));
        } while (!CommandService.isExitCommand(cmd));
    }

    public static boolean editContact(int id, int choice, String value) {
        if (value.isEmpty())
            return false;

        Contact contact = contacts.get(id);
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