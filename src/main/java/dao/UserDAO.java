package dao;

import model.User;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements UserDAOInterface{
    @Override
    public boolean insertUser(User user) {
        if (user == null || user.getName() == null || user.getName().trim().isEmpty()){
            return false;
        }
        String sql = "INSERT INTO profile(name, email, password) VALUES (?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

        ps.setString(1, user.getName().trim());
        ps.setString(2, user.getEmail().trim());
        ps.setString(3, user.getPassword().trim());
        int rows = ps.executeUpdate();
        return rows>0;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT id, name, email FROM profile ORDER BY id";

        try(Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
//                String password = rs.getString("password");

//                User user = new User(id, name, email, password);
                User user = new User(id, name, email);
                users.add(user);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT id, name, email, password FROM profile WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")
            );
        }
    }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}