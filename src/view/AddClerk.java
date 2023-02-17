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
                String fullName = tFieldFullName.getText();
                String username = tFieldUsername.getText();
                String email = tFieldEmail.getText();
                String password = tFieldPassword.getText();
                String cpassword = tFieldCPassword.getText();

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
        if (clerk != null){
            System.out.println("not empty");
        } else {
            System.out.println("empty");
        }
    }
}
