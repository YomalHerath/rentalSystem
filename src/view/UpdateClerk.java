package view;

import controller.ClerkImplement;
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

    public UpdateClerk(int clerkId){
        super();
        setTitle("Room Rental System");
        setContentPane(UpdateClerkPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,500));
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
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clerk clerk = new Clerk();

                String fullName = tFieldFullName.getText();
                String username = tFieldUsername.getText();
                String email = tFieldEmail.getText();

                clerk.setFullName(fullName);
                clerk.setUsername(username);
                clerk.setEmail(email);
                clerk.setClerkId(clerkId);

                // Load the data in a separate thread
                new Thread(() -> {
                    ClerkImplement clerkImplement = new ClerkImplement();
                    clerkImplement.update(clerk);
                    ManageClerks manageClerks = new ManageClerks();
                    manageClerks.Load();
                    dispose();
                }).start();

            }
        });
    }

    public static void main(String[] args) {
    }
}
