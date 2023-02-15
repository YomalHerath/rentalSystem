package view;

import controller.UserImplement;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagement extends JDialog {
    private JPanel UserManagePanel;
    private JLabel lblTxt;
    private JLabel lblUsername;
    private JTextField tFieldUsername;
    private JLabel lblEmail;
    private JLabel lblPassword;
    private JLabel lblCPasssword;
    private JTextField tFieldEmail;
    private JButton btnSave;
    private JButton btnDelete;
    private JPasswordField tFieldCPassword;
    private JPasswordField tFieldPassword;

    public UserManagement(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(UserManagePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,550));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //get field values from model class
                User user = new User();
                String username = tFieldUsername.getText();
                String email = tFieldEmail.getText();
                String password = tFieldPassword.getText();
                String cpassword = tFieldCPassword.getText();

                user.setUsername(username);
                user.setUserEmail(email);
                user.setUserPassword(password);

                // check password and confirm password
                if (password == cpassword) {
                    UserImplement userImplement = new UserImplement();
                    userImplement.save(user);

                    //clear text fields
                    tFieldUsername.setText("");
                    tFieldEmail.setText("");
                    tFieldPassword.setText("");
                    tFieldCPassword.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Mismatch Password and Confirm Password");
                }

            }
        });
    }

    public static void main(String[] args) {
        UserManagement dashboard = new UserManagement(null);
    }
}
