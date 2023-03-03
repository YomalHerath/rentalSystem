package controller.clerk;

import database.DBConnection;
import model.Clerk;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClerkImplement {

    public void save(Clerk clerk) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String query = "INSERT INTO clerk(fullName,username,email,password) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, clerk.getFullName());
                preparedStatement.setString(2, clerk.getUsername());
                preparedStatement.setString(3, clerk.getEmail());
                preparedStatement.setString(4, clerk.getPassword());
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Saved!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Fail to insert clerk" + e.getMessage());
            }
        });
        thread.start();
    }

    public void update(Clerk clerk) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "UPDATE clerk SET fullname=?,username=?,email=? WHERE clerkId=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, clerk.getFullName());
                ps.setString(2, clerk.getUsername());
                ps.setString(3, clerk.getEmail());
                ps.setInt(4, clerk.getClerkId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Fail to update clerk" + e.getMessage());
            }
        });
        thread.start();
    }

    public Clerk get(int clerkId) {
        Clerk clerk = new Clerk();
        Thread thread = new Thread(() -> {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM clerk WHERE clerkId=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, clerkId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                clerk.setClerkId(resultSet.getInt("clerkId"));
                clerk.setFullName(resultSet.getString("fullName"));
                clerk.setUsername(resultSet.getString("username"));
                clerk.setEmail(resultSet.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return clerk;
    }

    public List<Clerk> list() {
        List<Clerk> list = new ArrayList<Clerk>();
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * FROM clerk WHERE userType = 0";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                //data will be added until finish
                while (resultSet.next()) {
                    Clerk clerk = new Clerk();
                    clerk.setClerkId(resultSet.getInt("clerkId"));
                    clerk.setFullName(resultSet.getString("fullName"));
                    clerk.setUsername(resultSet.getString("username"));
                    clerk.setEmail(resultSet.getString("email"));
                    list.add(clerk);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }


}
