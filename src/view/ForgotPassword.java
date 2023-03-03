package view;

import controller.Login.LoginImplement;
import controller.clerk.ClerkImplement;
import model.Clerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForgotPassword extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblForgotLoginTopic;
    private JPanel JPanel3;
    private JLabel lblPassword;
    private JLabel lblCPassword;
    private JPasswordField tFieldCPassword;
    private JButton btnSave;
    private JPanel JPanel4;
    private JLabel lblImage;
    private JPanel ForgotPassPanel;
    private JButton btnCancel;
    private JPasswordField tFieldPassword;
    private JTextField tFieldEmail;

    public ForgotPassword() {
        super();
        setTitle("Room Rental System");
        setContentPane(ForgotPassPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(800, 450));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ForgotPassPanel);
        setVisible(true);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clerk clerk = new Clerk();

                String email = tFieldEmail.getText();
                String password = tFieldPassword.getText();
                String cpassword = tFieldCPassword.getText();

                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldEmail, "Enter Email", "Error", JOptionPane.ERROR_MESSAGE);

                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldPassword, "Enter Password", "Error", JOptionPane.ERROR_MESSAGE);

                } else if (cpassword.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldCPassword, "Enter Confrim Password", "Error", JOptionPane.ERROR_MESSAGE);

                } else if (!password.equals(cpassword)) {
                    JOptionPane.showMessageDialog(null, "Not Equal Passwords", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
// Create a new ExecutorService with a fixed pool of threads
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(new Runnable() {
                        public void run() {
                            try {
                                //set text
                                clerk.setEmail(email);
                                clerk.setPassword(password);

                                // Pass data for controller to add them to the database
                                LoginImplement loginImplement = new LoginImplement();
                                loginImplement.ForgotPassword(email, password);

                                tFieldEmail.setText("");
                                tFieldPassword.setText("");
                                tFieldCPassword.setText("");

                                //close form view
                                dispose();
                                //call manage clerk view page
                                Login login = new Login();
                                login.setVisible(true);

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    executor.shutdown();
                }
            }
        });
    }

    public static void main(String[] args) {
        ForgotPassword forgotPassword = new ForgotPassword();
    }
}
