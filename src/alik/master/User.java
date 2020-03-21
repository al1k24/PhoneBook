package alik.master;

public class User {

    private int id;

    private String name;
    private String surname;
    private String phone;

    public User(int id, String name, String surname, String phone) {
        this.id = id;

        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public int getUserId() {
        return id;
    }

    public String getUserName() {
        return name + " " + surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullInfo() {
        return "ID: " + getUserId() + " -> " + getUserName() + " | Phone: " + getPhone();
    }

    public boolean isUserId(int id) {
        return getUserId() == id;
    }
}
