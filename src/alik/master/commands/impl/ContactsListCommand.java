package alik.master.commands.impl;

import alik.master.commands.CommandExecution;
import alik.master.model.Contact;
import alik.master.service.DataBaseService;

import java.sql.SQLException;
import java.util.Map;

public class ContactsListCommand implements CommandExecution {

    @Override
    public void execute() {
        try {
            DataBaseService dbs = new DataBaseService();
            Map<Integer, Contact> contacts = dbs.getContacts();

            contacts.forEach((id, contact) -> System.out.println("ID: " + id + " | " + contact.getFullName() + " Tel: " + contact.getPhone()));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
