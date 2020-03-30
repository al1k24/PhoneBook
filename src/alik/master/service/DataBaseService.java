package alik.master.service;

import alik.master.model.Contact;
import alik.master.model.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataBaseService {

    DataBase db = new DataBase();

    public void createTableIfNotExists() throws ClassNotFoundException, SQLException {
        String request = "CREATE TABLE IF NOT EXISTS `u0533070_pb`.`contacts` ( " +
                "`id` INT NOT NULL AUTO_INCREMENT, " +
                "`name` VARCHAR(25) NULL, " +
                "`surname` VARCHAR(25) NULL, " +
                "`phone` VARCHAR(9) NULL, " +
                "PRIMARY KEY (`id`)) ENGINE = MyISAM CHARACTER SET utf8 COLLATE utf8_general_ci;";

        db.getConnection().prepareStatement(request).executeUpdate();
    }

    public boolean addContact(Contact contact) throws ClassNotFoundException, SQLException {
        String request = "INSERT INTO `contacts`(`name`, `surname`, `phone`) VALUES (?,?,?)";

        PreparedStatement ps = db.getConnection().prepareStatement(request);
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getSurname());
        ps.setString(3, contact.getPhone());

        return ps.executeUpdate() > 0;
    }

    public boolean editContact(int id, int choice, String value) throws ClassNotFoundException, SQLException {
        String request;
        switch (choice) {
            case 1:
                request = "UPDATE `contacts` SET `name`=? WHERE `id`=?";
                break;
            case 2:
                request = "UPDATE `contacts` SET `surname`=? WHERE `id`=?";
                break;
            case 3:
                request = "UPDATE `contacts` SET `phone`=? WHERE `id`=?";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

        PreparedStatement ps = db.getConnection().prepareStatement(request);
        ps.setString(1, value);
        ps.setInt(2, id);

        return ps.executeUpdate() > 0;
    }

    public boolean removeContact(int id) throws ClassNotFoundException, SQLException {
        String request = "DELETE FROM `contacts` WHERE `id` = ?";

        PreparedStatement ps = db.getConnection().prepareStatement(request);
        ps.setInt(1, id);

        return ps.executeUpdate() > 0;
    }

    public Map<Integer, Contact> getContacts() throws ClassNotFoundException, SQLException {
        Map<Integer, Contact> contacts = new HashMap<>();

        String request = "SELECT * FROM `contacts`";

        PreparedStatement ps = db.getConnection().prepareStatement(request);

        int id;
        String name, surname, phone;

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            id = result.getInt("id");
            name = result.getString("name");
            surname = result.getString("surname");
            phone = result.getString("phone");

            contacts.put(id, new Contact(name, surname, phone));
        }

        return contacts;
    }
}
