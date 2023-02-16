package view;

import javax.swing.*;
import java.awt.*;

public class AddMaintenance extends JDialog {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddReservation;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomType;
    private JLabel lblFillRoomType;
    private JLabel lblMaintenanceDate;
    private JTextField tFieldMDate;
    private JLabel lblMaintenanceTime;
    private JTextField tFieldMTime;
    private JButton btnSave;
    private JButton btnCancel;
    private JPanel AddMaintenancePanel;

    public AddMaintenance(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(AddMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,450));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        AddMaintenance addMaintenance = new AddMaintenance(null);
    }
}
