package view;

import javax.swing.*;
import java.awt.*;

public class ManageReservationDetails extends JDialog{
    private JPanel JPanel2;
    private JLabel lblManageRoom;
    private JTextField tFieldReservationSearch;
    private JButton btnReservationSearch;
    private JButton btnRoomUpdate;
    private JButton btnRoomReservation;
    private JTable tableReservationDetails;
    private JPanel ManageReservationPanel;

    public ManageReservationDetails(JFrame jFrame){
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
        ManageReservationDetails manageReservationDetails = new ManageReservationDetails(null);
    }
}
