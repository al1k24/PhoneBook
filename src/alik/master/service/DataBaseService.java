package alik.master.service;

import alik.master.model.Contact;
import alik.master.model.DataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public boolean removeContact(int id) throws ClassNotFoundException, SQLException {
        String request = "DELETE FROM `contacts` WHERE `id` = ?";

        PreparedStatement ps = db.getConnection().prepareStatement(request);
        ps.setInt(1, id);

        return ps.executeUpdate() > 0;
    }
}
