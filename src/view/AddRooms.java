package view;

import javax.swing.*;
import java.awt.*;

public class AddRooms extends JDialog {
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
    private JComboBox comboBoxRoomSize;

    public AddRooms(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(AddRoomDetailsPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,450));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        AddRooms addRoomDetails = new AddRooms(null);
    }

}
