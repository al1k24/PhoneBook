package alik.master.commands.impl;

import alik.master.commands.CommandExecution;
import alik.master.model.Contact;
import alik.master.service.PhoneBookService;

import java.util.Map;

public class ContactsListCommand implements CommandExecution {

    @Override
    public void execute() {
        Map<Integer, Contact> contacts = PhoneBookService.getContacts();
        contacts.forEach((id, contact) -> System.out.println("ID: " + id + " | " + contact.getFullName() + " Tel: " + contact.getPhone()));
    }
}
