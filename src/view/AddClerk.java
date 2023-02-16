package view;

import javax.swing.*;
import java.awt.*;

public class AddClerk extends JDialog {
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

    public AddClerk(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(AddClerkPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,550));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        AddClerk addClerk = new AddClerk(null);
    }
}
