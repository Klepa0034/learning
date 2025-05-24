package entity;

public class User {
    private String name;
    private int id;

    public String getName() {
        return this.name = name;
    }

    public int getId() {
        return this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "users_names=" + name +
                ", id=" + id +
                '}';
    }
}
