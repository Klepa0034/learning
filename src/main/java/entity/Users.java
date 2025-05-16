package entity;

public class Users {
    private String users_names;
    private int user_id;

    public String getUsers_names() {
        return this.users_names = users_names;
    }

    public int getUser_id() {
        return this.user_id = user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsers_names(String users_names) {
        this.users_names = users_names;
    }

    public Users(String users_names, int user_id) {
        this.users_names = users_names;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "users_names=" + users_names +
                ", id=" + user_id +
                '}';
    }
}
