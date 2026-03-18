package view;

import controller.UserController;
import java.util.Scanner;

public class MainView{
    private final UserController controller = new UserController();
    private final Scanner scanner = new Scanner(System.in);

    public void startProgram(){
        while (true){
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            if(choice == 1){
                addUser();
            } else if (choice == 2) {
                viewAllUsers();
            } else if (choice == 3) {
                System.out.println("Enter your ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                viewUserById(id);
            } else if (choice == 4) {
                break;
            }else{
                System.out.println("Enter a valid option");
            }
        }
    }

    public void showMenu(){
        System.out.println("1,Add User \n2.View All Users \n3.View My Profile(by ID) \n4.Exit");
    }

    public void addUser(){
        System.out.println("Enter name, email and password: ");
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String password = scanner.nextLine();

        if(name.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()){
            System.out.println("Please enter all the fields.");
        }else {
            controller.AddUser(name, email, password);
            System.out.println("Profile added successfully.\n");
        }
    }

    public void viewAllUsers(){
        controller.showAllUsers();
        System.out.println(" ");
    }

    public void viewUserById(int id){
        controller.showUserById(id);
        System.out.println(" ");
    }
}





