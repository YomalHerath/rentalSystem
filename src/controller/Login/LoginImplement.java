package controller.Login;

import database.DBConnection;
import model.Clerk;
import view.Login;
import view.Manager.ManagerDashboard;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginImplement {
    private boolean loggedIn;
    public boolean LoginAuthenticate(String email, String password) {
        Clerk clerk = new Clerk();
        try {
            //get connection
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM clerk WHERE email='"+email+"' AND password ='"+password+"'";

            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                if (resultSet.getString("userType").equals("1")){
                    JOptionPane.showMessageDialog(null,"Login Successful!");
                    ManagerDashboard managerDashboard = new ManagerDashboard();
                    managerDashboard.setVisible(true);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null,"Login Successful!");
                    ManagerDashboard managerDashboard = new ManagerDashboard();
                    managerDashboard.setVisible(true);
                    return true;
                }

            } else {
                JOptionPane.showMessageDialog(null,"Invalid email or password, Try again!");
                Login login = new Login();
                login.setVisible(true);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            loggedIn = false;
            return false;
        }
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void ForgotPassword(String email, String password){
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "UPDATE clerk SET password=? WHERE email=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, password);
                ps.setString(2, email);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Fail to update clerk" + e.getMessage());
            }
        });
        thread.start();
    }
}


