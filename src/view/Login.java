package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog {
    private JPanel LoginPanel;
    private JLabel lblLoginTopic;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JLabel lblEmail;
    private JTextField textField1;
    private JLabel lblPassword;
    private JPasswordField passwordField1;
    private JButton btnSignIn;
    private JLabel lblImage;
    private JButton btnCancel;


    public Login(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(LoginPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(800,400));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Login login = new Login(null);
    }

}
