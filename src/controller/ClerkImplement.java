package controller;

import database.DBConnection;
import model.Clerk;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ClerkImplement implements ClerkInterface {

    @Override
    public void save(Clerk clerk) {
        try {
            Connection con =  DBConnection.getConnection();
            String query = "INSERT INTO students(fullName,username,email,password) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, clerk.getFullName());
            preparedStatement.setString(2, clerk.getUsername());
            preparedStatement.setString(3, clerk.getEmail());
            preparedStatement.setString(4, clerk.getPassword());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Clerk clerk) {

    }

    @Override
    public Clerk get(int clerkId) {
        return null;
    }

    @Override
    public List<Clerk> list() {
        return null;
    }
}
