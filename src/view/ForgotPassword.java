package view;

import javax.swing.*;
import java.awt.*;

public class ForgotPassword extends JDialog {
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

    public ForgotPassword(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(ForgotPassPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(800,450));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        ForgotPassword forgotPassword = new ForgotPassword(null);
    }
}
