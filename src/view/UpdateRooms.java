package view;

import javax.swing.*;
import java.awt.*;

public class UpdateRooms extends JDialog {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblUpdateRoom;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JTextField tFieldRoomNo;
    private JLabel lblRoomType;
    private JComboBox comboBoxRoomType;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JPanel UpdateRoomPanel;
    private JComboBox comboBoxRoomSize;

    public UpdateRooms(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(UpdateRoomPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,450));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        UpdateRooms updateRoomDetails = new UpdateRooms(null);
    }

}
