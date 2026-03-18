package dao;

import model.User;

import java.util.ArrayList;

public interface UserDAOInterface {
    boolean insertUser(User user);
    ArrayList<User> getAllUsers();
    public User getUserById(int id);
}
