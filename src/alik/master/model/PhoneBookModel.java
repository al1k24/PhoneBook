package alik.master.model;

import java.util.HashMap;
import java.util.Map;

public class PhoneBookModel {

    protected static int id;

    protected static final Map<Integer, ContactModel> contacts = new HashMap<>();

    public static Map<Integer, ContactModel> getContacts() {
        return contacts;
    }
}
