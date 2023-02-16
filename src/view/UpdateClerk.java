package view;

import javax.swing.*;
import java.awt.*;

public class UpdateClerk extends JDialog {
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

    public UpdateClerk(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(UpdateClerkPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,450));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        UpdateClerk updateClerk = new UpdateClerk(null);
    }
}
