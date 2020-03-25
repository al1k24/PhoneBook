import alik.master.service.DataBaseService;
import alik.master.service.PhoneBookService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DataBaseService dbs = new DataBaseService();
        try {
            dbs.createTableIfNotExists();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return;
        }

        PhoneBookService.start();
    }
}
