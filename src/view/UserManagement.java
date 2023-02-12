package view;

import javax.swing.*;
import java.awt.*;

public class UserManagement extends JDialog {
    private JPanel UserManagePanel;
    private JLabel lblTxt;

    public UserManagement(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(UserManagePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        UserManagement dashboard = new UserManagement(null);
    }
}
