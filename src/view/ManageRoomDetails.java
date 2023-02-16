package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManageRoomDetails extends JDialog {
    private JPanel ManageRoomPanel;
    private JPanel JPanel2;
    private JLabel lblManageRoom;
    private JButton btnAddRoom;
    private JTextField tFieldRoomSearch;
    private JButton btnRoomSearch;
    private JTable tableRoomDetails;
    private JButton btnRoomUpdate;
    private JButton btnRoomReservation;

    // create heading for table with create table method
    void createTable() {
        tableRoomDetails.setModel(new DefaultTableModel(
                null,
                new String[]{
                        "Room No", "Room Type", "Room Size", "Availability", "Action"
                }
        ));
    }

    public ManageRoomDetails(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(ManageRoomPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManageRoomDetails manageRoomDetails = new ManageRoomDetails(null);
    }

}
