package view;

import controller.Login.LoginImplement;
import model.Clerk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel LoginPanel;
    private JLabel lblLoginTopic;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JLabel lblEmail;
    private JTextField tFieldEmail;
    private JLabel lblPassword;
    private JPasswordField tFieldPassword;
    private JButton btnSignIn;
    private JLabel lblImage;
    private JButton btnCancel;
    private JButton forgotPasswordButton;

    public Clerk clerk;

    public Login() {
        super();
        setTitle("Room Rental System");
        setContentPane(LoginPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(800, 400));
        //display dialog in the middle of the frame
        setLocationRelativeTo(LoginPanel);
        setVisible(true);

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            //get user input values
                            String email = tFieldEmail.getText();
                            String password = tFieldPassword.getText();

                            if (email.isEmpty()) {
                                JOptionPane.showMessageDialog(tFieldEmail, "Enter Email", "Error", JOptionPane.ERROR_MESSAGE);
                            } else if (password.isEmpty()) {
                                JOptionPane.showMessageDialog(tFieldPassword, "Enter Password", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                LoginImplement loginImplement = new LoginImplement();
                                loginImplement.LoginAuthenticate(email, password);
                                dispose();
                            }

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                // Start the login process in a separate thread
                thread.start();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ForgotPassword forgotPassword = new ForgotPassword();
                forgotPassword.setVisible(true);
            }
        });
    }

    private Clerk LoginAuthenticate(String email, String password) {
        Clerk clerk = null;
        return clerk;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
