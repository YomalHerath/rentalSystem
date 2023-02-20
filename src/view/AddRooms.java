package view;

import controller.room.RoomImplement;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame {
    private JPanel AddRoomDetailsPanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddRoom;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JTextField tFieldRoomNo;
    private JLabel lblRoomType;
    private JButton btnSave;
    private JComboBox comboBoxRoomType;
    private JButton btnCancel;
    private JSpinner spinnerRoomSize;

    public AddRooms(){
        super();
        setTitle("Room Rental System");
        setContentPane(AddRoomDetailsPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,450));
        //display dialog in the middle of the frame
        setLocationRelativeTo(AddRoomDetailsPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Room room = new Room();
                String roomNo = tFieldRoomNo.getText().trim();
                String roomType = comboBoxRoomType.getSelectedItem().toString();
                int roomSize = (Integer) spinnerRoomSize.getValue();

                // validate form fields
                if (roomNo.isEmpty()){
                    JOptionPane.showMessageDialog(tFieldRoomNo, "Enter Room No", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (roomSize < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a value more than 0");
                    spinnerRoomSize.setValue(0);
                } else {
                    //set text
                    room.setRoomNo(roomNo);
                    room.setRoomType(roomType);
                    room.setRoomSize(roomSize);

                    RoomImplement roomImplement = new RoomImplement();
                    roomImplement.save(room);
                    tFieldRoomNo.setText("");
                    spinnerRoomSize.setValue(0);
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

    public Room room;

    public static void main(String[] args) {
        AddRooms addRoomDetails = new AddRooms();
        Room room = addRoomDetails.room;
    }

}
