package view.Clerk;

import controller.room.RoomImplement;
import model.Room;
import view.Manager.AddReservation;
import view.Manager.AddRooms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewRoom extends JFrame {
    private JPanel ManageRoomPanel;
    private JPanel JPanel2;
    private JLabel lblManageRoom;
    private JButton btnAddRoom;
    private JTextField tFieldRoomSearch;
    private JButton btnRoomSearch;
    private JTextField tFieldRoomId;
    private JButton btnAddReservation;
    private JButton btnAddMaintenance;
    private JButton btnUpdateRoom;
    private JButton btnRemoveRoom;
    private JTable tableRoomDetails;

    private String[] data;

    // create heading for table with create table method
    void createTable() {
        tableRoomDetails.setModel(new DefaultTableModel(
                null,
                new String[]{
                        "Room No", "Room Type", "Room Size", "Availability", "Action"
                }
        ));
    }

    public ViewRoom(){
        super();
        setTitle("Room Rental System");
        setContentPane(ManageRoomPanel);
        setMinimumSize(new Dimension(1280,720));
        setLocationRelativeTo(ManageRoomPanel);
        setResizable(false);
        setVisible(true);

        btnAddReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pass clerk id to update form
                String roomNo = tFieldRoomId.getText().trim();

                //validate field
                if (roomNo.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldRoomId, "Enter Room No", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //pass clerk id and view form
                    String passing_roomId = roomNo;
                    AddReservation addReservation = new AddReservation(passing_roomId);
                    dispose();
                }

            }
        });
    }

    //create a method for view data in table view
    public void Load() {

        //create room implementation object
        RoomImplement roomImplement = new RoomImplement();
        //define column Names
        String[] columnNames = {"Room No", "Room Type", "Room Size", "Availability", "Status"};

        //store data into jTable
        List<Room> list = roomImplement.list();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableRoomDetails.getModel();
        defaultTableModel.setColumnIdentifiers(columnNames);
        defaultTableModel.setRowCount(0);

        //add header color and font style in table
        JTableHeader header = tableRoomDetails.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        Font font = new Font("Fira Code", Font.BOLD, 16);
        header.setFont(font);

        //fill table raws with database values by model class
        for (Room room : list) {
            String roomNo = room.getRoomNo();
            String roomType = room.getRoomType();
            String roomSize = String.valueOf(room.getRoomSize());
            String availability = room.getRoomAvailability();
            String status = room.getRoomStatus();
            defaultTableModel.addRow(new Object[]{roomNo, roomType, roomSize, availability, status});
        }

    }

    public static void main(String[] args) {
        ViewRoom manageRoomDetails = new ViewRoom();
        manageRoomDetails.Load();
    }

}
