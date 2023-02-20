package view;

import controller.clerk.ClerkImplement;
import model.Clerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateClerk extends JFrame {
    private JPanel UpdateClerkPanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblUpdateClerk;
    private JPanel JPanel3;
    private JLabel lblFullName;
    private JTextField tFieldFullName;
    private JLabel lblUsername;
    private JTextField tFieldUsername;
    private JLabel lblEmail;
    private JTextField tFieldEmail;
    private JButton btnUpdate;
    private JButton btnCancel;

    public UpdateClerk(int clerkId) {
        super();
        setTitle("Room Rental System");
        setContentPane(UpdateClerkPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400, 500));
        //display dialog in the middle of the frame
        setLocationRelativeTo(UpdateClerkPanel);
        setResizable(false);
        setVisible(true);


        ClerkImplement clerkImplement = new ClerkImplement();
        Clerk clerk = clerkImplement.get(clerkId);

        //set database value to text fields
        tFieldFullName.setText(clerk.getFullName());
        tFieldEmail.setText(clerk.getEmail());
        tFieldUsername.setText(clerk.getUsername());

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManageClerks manageClerks = new ManageClerks();
                manageClerks.Load();
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clerk clerk = new Clerk();

                // Define the regex pattern for email validation (not match)
                String emailPattern = "^(?:(?![a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}).)*$";

                // requires the username can contain only letters
                String usernamePattern = "^[a-zA-Z]$";

                String fullName = tFieldFullName.getText();
                String username = tFieldUsername.getText();
                String email = tFieldEmail.getText();

                //validate all form text fields
                if (fullName.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldFullName, "Enter Full Name", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldUsername, "Enter Username", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldEmail, "Enter Email", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (username.matches(usernamePattern)) {
                    JOptionPane.showMessageDialog(tFieldUsername, "Username must have a minimum length of 3 characters " +
                                    "and a maximum length of 20 characters, and can contain only letters",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else if (email.matches(emailPattern)) {
                    JOptionPane.showMessageDialog(tFieldEmail, "Invalid Email Format", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    clerk.setFullName(fullName);
                    clerk.setUsername(username);
                    clerk.setEmail(email);
                    clerk.setClerkId(clerkId);

                    ClerkImplement clerkImplement = new ClerkImplement();
                    clerkImplement.update(clerk);
                    ManageClerks manageClerks = new ManageClerks();
                    manageClerks.Load();
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
    }
}
