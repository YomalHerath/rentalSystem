package controller;

import database.DBConnection;
import model.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserImplement implements UserController {

    // user save method
    @Override
    public void save(User user) {

        try {
            Connection con =  DBConnection.getConnection();
            String query = "INSERT INTO user(usrname, userEmail, password, userType) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getUserEmail());
            ps.setString(3, user.getUserPassword());
            ps.setInt(4, user.getUserType());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User get(int userId) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }
}
