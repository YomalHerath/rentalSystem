package view;

import controller.room.RoomImplement;
import model.Room;

import javax.swing.*;
import java.awt.*;

public class AddReservation extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddReservation;
    private JPanel JPanel3;
    private JLabel lblClientName;
    private JTextField tFieldClientName;
    private JButton btnSave;
    private JButton btnCancel;
    private JPanel AddReservationPanel;
    private JLabel lblClientContactNo;
    private JTextField tFieldContactNo;
    private JComboBox comboBoxOccation;
    private JTextArea textAreaNote;
    private JLabel lblNote;
    private JLabel lblOccation;
    private JLabel lblReservedTime;
    private JLabel lblReservedDate;
    private JTextField tFiieldFromDate;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomNo;
    private JLabel lblRoomType;
    private JLabel lblFillRoomType;
    private JSpinner spinnerTime;
    private JComboBox comboBoxTimeSelect;
    private JTextField tFieldRToDate;

    public AddReservation(String roomNo){
        super();
        setTitle("Room Rental System");
        setContentPane(AddReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,720));
        //display dialog in the middle of the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        // create object in Implement class
        RoomImplement roomImplement = new RoomImplement();
        //call get function for retrieve data
        Room room = roomImplement.get(roomNo);

        //set database value to text fields
        lblFillRoomNo.setText(room.getRoomNo());

    }

    public static void main(String[] args) {
        AddReservation addReservation = new AddReservation(null);
    }
}

