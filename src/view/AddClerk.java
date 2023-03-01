package view;

import controller.clerk.ClerkImplement;
import database.DBConnection;
import model.Clerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddClerk extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddClerk;
    private JPanel JPanel3;
    private JLabel lblFullName;
    private JTextField tFieldFullName;
    private JLabel lblUsername;
    private JTextField tFieldUsername;
    private JLabel lblEmail;
    private JTextField tFieldEmail;
    private JLabel lblPassword;
    private JLabel lblConfirmPassword;
    private JButton btnSave;
    private JButton btnCancel;
    private JPanel AddClerkPanel;
    private JPasswordField tFieldPassword;
    private JPasswordField tFieldCPassword;

    // password uppercase and lowercase letter validation
    private static boolean containsUppercaseAndLowercase(String str) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                hasUppercase = true;
            } else if (Character.isLowerCase(str.charAt(i))) {
                hasLowercase = true;
            }

            if (hasUppercase && hasLowercase) {
                return true;
            }
        }
        return false;
    }

    //setup view of frame
    public AddClerk() {
        setTitle("Room Rental System");
        setContentPane(AddClerkPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400, 580));
        //display dialog in the middle of the frame
        setLocationRelativeTo(AddClerkPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //save function with btn click
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create clerk object from model class
                Clerk clerk = new Clerk();

                //get text field values
                String fullName = tFieldFullName.getText().trim();
                String username = tFieldUsername.getText().trim();
                String email = tFieldEmail.getText().trim();
                String password = tFieldPassword.getText().trim();
                String cpassword = tFieldCPassword.getText().trim();

                // Define the regex pattern for email validation (not match)
                String emailPattern = "^(?:(?![a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}).)*$";

                // requires the username can contain only letters
                String usernamePattern = "^[a-zA-Z]$";

                //validate all form text fields
                if (fullName.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldFullName, "Enter Full Name", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldUsername, "Enter Username", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldEmail, "Enter Email", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldPassword, "Enter Password", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (cpassword.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldCPassword, "Enter Confirm Password", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (username.matches(usernamePattern)) {
                    JOptionPane.showMessageDialog(tFieldUsername, "Username must have a minimum length of 3 characters " +
                                    "and a maximum length of 20 characters, and can contain only letters",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else if (email.matches(emailPattern)) {
                    JOptionPane.showMessageDialog(tFieldEmail, "Invalid Email Format", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (password.length() < 6) {
                    JOptionPane.showMessageDialog(tFieldEmail, "Password must be at least 6 characters long", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!containsUppercaseAndLowercase(password)) {
                    JOptionPane.showMessageDialog(tFieldEmail, "Password must contain at least one uppercase letter and lowercase letter", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.matches(cpassword)) {
                    JOptionPane.showMessageDialog(tFieldPassword, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    Thread thread = new Thread(new Runnable() {
                        public void run() {
                            try {
                                try {
                                    Connection con = DBConnection.getConnection();
                                    String check_email = "SELECT email From clerk WHERE email =?";
                                    PreparedStatement preparedStatement = con.prepareStatement(check_email);
                                    preparedStatement.setString(1, email);
                                    ResultSet resultSet = preparedStatement.executeQuery();
                                    if (resultSet.next()) { // check email id already taken
                                        JOptionPane.showMessageDialog(tFieldEmail, "Entered Email Address Already Taken", "Error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        //set text
                                        clerk.setFullName(fullName);
                                        clerk.setEmail(email);
                                        clerk.setUsername(username);
                                        clerk.setPassword(password);

                                        // Pass data for controller to add them to the database
                                        ClerkImplement clerkImplement = new ClerkImplement();
                                        clerkImplement.save(clerk);

                                        //set text field null
                                        tFieldFullName.setText("");
                                        tFieldEmail.setText("");
                                        tFieldUsername.setText("");
                                        tFieldPassword.setText("");
                                        tFieldCPassword.setText("");
                                        tFieldFullName.requestFocus();

                                        //call manage clerk view page
                                        ManageClerks manageClerks = new ManageClerks();
                                        manageClerks.Load();
                                        //close form view
                                        dispose();
                                    }
                                } catch (Exception exception) {
                                    exception.printStackTrace();
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    // Start the process in a separate thread
                    thread.start();
                }
            }
        });

        // cancel btn click function
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManageClerks manageClerks = new ManageClerks();
                manageClerks.Load();
            }
        });
    }

    // create clerk object in public
    public Clerk clerk;

    public static void main(String[] args) {
        AddClerk addClerk = new AddClerk();
        Clerk clerk = addClerk.clerk;
    }
}
