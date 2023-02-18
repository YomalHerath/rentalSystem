package view;

import controller.ClerkImplement;
import model.Clerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public AddClerk(){
        setTitle("Room Rental System");
        setContentPane(AddClerkPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,550));
        //display dialog in the middle of the frame
        setLocationRelativeTo(AddClerkPanel);
        setVisible(true);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clerk clerk = new Clerk();
                String fullName = tFieldFullName.getText().trim();
                String username = tFieldUsername.getText().trim();
                String email = tFieldEmail.getText().trim();
                String password = tFieldPassword.getText().trim();
                String cpassword = tFieldCPassword.getText().trim();

                // Define the regex pattern for email validation (not match)
                String emailPattern = "^(?:(?![a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}).)*$";

                // requires the password to have at least one uppercase letter, one lowercase letter, one digit, one special character, and a minimum length of 8 characters
                String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

                // requires the username to have a minimum length of 3 characters and a maximum length of 20 characters, and can contain only letters, digits, and underscores
                String usernamePattern = "^[a-zA-Z]{3,20}$";

                //validate text fields
                if (fullName.isEmpty()){
                    JOptionPane.showMessageDialog(tFieldFullName, "Enter Full Name", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (username.isEmpty()){
                    JOptionPane.showMessageDialog(tFieldUsername, "Enter Username", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (email.isEmpty()){
                    JOptionPane.showMessageDialog(tFieldEmail, "Enter Email", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (password.isEmpty()){
                    JOptionPane.showMessageDialog(tFieldPassword, "Enter Password", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (cpassword.isEmpty()){
                    JOptionPane.showMessageDialog(tFieldCPassword, "Enter Confirm Password", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (username.matches(usernamePattern)){
                    JOptionPane.showMessageDialog(tFieldUsername, "Username must have a minimum length of 3 characters " +
                                    "and a maximum length of 20 characters, and can contain only letters",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else if (email.matches(emailPattern)){
                    JOptionPane.showMessageDialog(tFieldEmail, "Invalid Email Format", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.matches(passwordPattern)){
                    JOptionPane.showMessageDialog(tFieldPassword, "Password must have at least one uppercase letter, " +
                            "one lowercase letter, one digit, one special character, and a minimum length of 8 characters",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.matches(cpassword)){
                    JOptionPane.showMessageDialog(tFieldPassword, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //set text
                    clerk.setFullName(fullName);
                    clerk.setEmail(email);
                    clerk.setUsername(username);
                    clerk.setPassword(password);

                    ClerkImplement clerkImplement = new ClerkImplement();
                    clerkImplement.save(clerk);
                    tFieldFullName.setText("");
                    tFieldEmail.setText("");
                    tFieldUsername.setText("");
                    tFieldPassword.setText("");
                    tFieldCPassword.setText("");
                    tFieldFullName.requestFocus();
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public Clerk clerk;

    public static void main(String[] args) {
        AddClerk addClerk = new AddClerk();
        Clerk clerk = addClerk.clerk;
    }
}
