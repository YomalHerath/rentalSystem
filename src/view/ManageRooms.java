package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManageRooms extends JFrame {
    private JPanel ManageRoomPanel;
    private JPanel JPanel2;
    private JLabel lblManageRoom;
    private JButton btnAddRoom;
    private JTextField tFieldRoomSearch;
    private JButton btnRoomSearch;
    private JTable tableRoomDetails;
    private JButton btnUpdateRoom;
    private JButton btnAddReservation;
    private JTextField tFieldRoomId;
    private JButton btnRemoveRoom;

    // create heading for table with create table method
    void createTable() {
        tableRoomDetails.setModel(new DefaultTableModel(
                null,
                new String[]{
                        "Room No", "Room Type", "Room Size", "Availability", "Action"
                }
        ));
    }

    public ManageRooms(){
        super();
        setTitle("Room Rental System");
        setContentPane(ManageRoomPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ManageRoomPanel);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManageRooms manageRoomDetails = new ManageRooms();
    }

}
