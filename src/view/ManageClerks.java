package view;

import javax.swing.*;
import java.awt.*;

public class ManageClerks extends JDialog {
    private JPanel ManageClerksPanel;
    private JPanel JPanel2;
    private JLabel lblManageClerks;
    private JButton btnAddClerks;
    private JTextField tFieldClerksSearch;
    private JButton btnClerksSearch;
    private JTextField tFieldClerksId;
    private JButton btnUpdateClerks;
    private JTable tableClerksDetails;

    public ManageClerks(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(ManageClerksPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManageClerks manageClerks = new ManageClerks(null);
    }
}
