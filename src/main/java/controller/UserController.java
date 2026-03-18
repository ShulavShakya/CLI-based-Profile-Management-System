package controller;

import dao.UserDAO;
import dao.UserDAOInterface;
import model.User;
import java.util.ArrayList;

public class UserController{
    private final UserDAOInterface userDAO;
    public UserController(){
        this.userDAO = new UserDAO();
    }

    public boolean AddUser(String name, String email, String password){
        User newUser = new User(0, name, email, password);
        return userDAO.insertUser(newUser);
    }

    public void showAllUsers(){
        ArrayList<User> users = userDAO.getAllUsers();
        if(users == null || users.isEmpty()){
            System.out.println("No users found");
        }else{
            for(User u : users){
                System.out.println("Id: " + u.getId() + " Name: " + u.getName());
            }
        }
    }

    public void showUserById(int id){
//        System.out.println("ID: " + id);
        User user = userDAO.getUserById(id);
        if(user != null){
            System.out.println("User Details: " + user.getName() + "( " + user.getEmail() + " )");
        }else{
            System.out.println("User with Id " + id + " not found");
        }
    }
}














