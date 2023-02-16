package view;

import javax.swing.*;
import java.awt.*;

public class ManageReservation extends JDialog{
    private JPanel JPanel2;
    private JLabel lblManageRoom;
    private JTextField tFieldReservationSearch;
    private JButton btnReservationSearch;
    private JTable tableReservationDetails;
    private JPanel ManageReservationPanel;
    private JButton btnUpdateReservation;
    private JButton btnViewReservation;
    private JTextField tFieldReservationId;

    public ManageReservation(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(ManageReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManageReservation manageReservationDetails = new ManageReservation(null);
    }
}
