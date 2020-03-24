package alik.master.commands;

import alik.master.model.ContactModel;
import alik.master.service.PhoneBook;

import java.util.Map;

public class ContactsListCommand implements CommandExecution {

    @Override
    public void execute() {
        Map<Integer, ContactModel> contacts = PhoneBook.getContacts();
        contacts.forEach((id, contact) -> System.out.println("ID: " + id + " | " + contact.getFullName() + " Tel: " + contact.getPhone()));
    }
}
