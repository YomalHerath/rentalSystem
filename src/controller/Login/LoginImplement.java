package controller.Login;

import database.DBConnection;
import model.Clerk;
import view.ClerkDashboard;
import view.Login;
import view.ManagerDashboard;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;

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
                JOptionPane.showMessageDialog(null,"Login Successful!");
                ManagerDashboard managerDashboard = new ManagerDashboard();
                managerDashboard.setVisible(true);
                return true;
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
}
