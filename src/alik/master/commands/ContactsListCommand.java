package alik.master.commands;

import alik.master.model.Contact;
import alik.master.service.PhoneBook;

import java.util.ArrayList;

public class UsersListCommand implements CommandExecution {

    @Override
    public void execute() {
        PhoneBook pb = new PhoneBook();

        ArrayList<Contact> contacts = pb.getContacts();
        for (Contact contact : contacts) {
            System.out.println("ID: " + contact.getId() + " | " + contact.getFullName() + " Tel: " + contact.getPhone());
        }
    }
}
