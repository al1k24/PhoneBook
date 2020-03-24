package alik.master.model;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    protected static int id;

    protected static final Map<Integer, Contact> contacts = new HashMap<>();

    public static Map<Integer, Contact> getContacts() {
        return contacts;
    }
}
