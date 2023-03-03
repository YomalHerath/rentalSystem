package view;

import controller.room.RoomImplement;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRooms extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblUpdateRoom;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JTextField tFieldRoomNo;
    private JLabel lblRoomType;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JPanel UpdateRoomPanel;
    private JComboBox comboBoxRoomType;
    private JTextField tFieldRoomSize;
    private JComboBox comboBoxAvailability;
    private JComboBox comboBoxStatus;

    public UpdateRooms(String roomNo) {
        super();
        setTitle("Room Rental System");
        setContentPane(UpdateRoomPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400, 600));
        //display dialog in the middle of the frame
        setLocationRelativeTo(UpdateRoomPanel);
        setResizable(false);
        setVisible(true);

        // create object in Implement class
        RoomImplement roomImplement = new RoomImplement();
        //call get function for retrieve data
        Room room = roomImplement.get(roomNo);

        //set database value to text fields
        tFieldRoomNo.setText(room.getRoomNo());
        comboBoxRoomType.setSelectedItem(room.getRoomType());
        tFieldRoomSize.setText(String.valueOf(room.getRoomSize()));
        comboBoxAvailability.setSelectedItem(room.getRoomAvailability());
        comboBoxStatus.setSelectedItem(room.getRoomStatus());
        int id = room.getRoomId();
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //create model class object
                Room room = new Room();
                //get text field values
                String roomNo = tFieldRoomNo.getText();
                String roomType = comboBoxRoomType.getSelectedItem().toString();
                int roomSize = Integer.parseInt(tFieldRoomSize.getText());
                String roomAvailability = comboBoxAvailability.getSelectedItem().toString();
                String roomStatus = comboBoxStatus.getSelectedItem().toString();

                //validate field
                if (roomNo.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldRoomNo, "Room No cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (roomSize < 0) {
                    JOptionPane.showMessageDialog(tFieldRoomSize, "Enter valid seat Count", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                room.setRoomNo(roomNo);
                                room.setRoomType(roomType);
                                room.setRoomSize(roomSize);
                                room.setRoomAvailability(roomAvailability);
                                room.setRoomStatus(roomStatus);
                                room.setRoomId(id);

                                RoomImplement roomImplement = new RoomImplement();
                                roomImplement.update(room);
                                ManageRooms manageRooms = new ManageRooms();
                                manageRooms.Load();
                                dispose();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    thread.start();

                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManageRooms manageRooms = new ManageRooms();
                manageRooms.Load();
            }
        });
    }

    public static void main(String[] args) {
    }

}
