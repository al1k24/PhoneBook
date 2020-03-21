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

    public int getId() {
        return id;
    }

    public String getName() {
        return name + " " + surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullInfo() {
        return "ID: " + getId() + " -> " + getName() + " | Phone: " + getPhone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isUserId(int id) {
        return getId() == id;
    }
}
