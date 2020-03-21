package alik.master;

import java.util.ArrayList;

public class PhoneBook {

    private final int NULL_USER = -1;

    private int userId = 0;

    private ArrayList<User> users = new ArrayList<User>();

    public PhoneBook(boolean bLoad) {
        if(bLoad) loadBestUsers();
    }

    //Лучшие из лучших
    public void loadBestUsers() {
        users.add(new User(++userId, "Алик", "Некодер", "77777777"));
        users.add(new User(++userId,"Илюха", "Сеньор", "10101010"));
        users.add(new User(++userId,"Витя", "Джун", "20202020"));
    }

    public boolean addUser(String name, String surname, String phone) {
        if(name.isEmpty() || surname.isEmpty() || phone.isEmpty())
            return false;

        return users.add(new User(++userId, name, surname, phone));
    }

    public boolean removeUser(int id) {
        int index = getUserObjectIndexById(id);
        if(index > NULL_USER) {
            users.remove(index);

            return true;
        }

        return false;
    }

    public boolean editUser(int id, EditType editType, String value) {


        return true;
    }

    public boolean hasUser(int id) {
        return getUserObjectIndexById(id) != NULL_USER;
    }

    public void showAllUsers() {
        if(users.size() > 0) {
            System.out.println("Список всех контактов:");

            for(User user:users) {
                System.out.println(user.getFullInfo());
            }
        } else {
            System.out.println("Нет контактов.");
        }
    }

    public String showUser(int id) {
        int index = getUserObjectIndexById(id);

        return users.get(index).getUserName();
    }

    private int getUserObjectIndexById(int id) {
        int index = NULL_USER;

        if(id < 1 || users.size() < 1)
            return index;

        for(User user:users) {
            if(user.isUserId(id)) {
                index = users.indexOf(user); break;
            }
        }

        return index;
    }
}
