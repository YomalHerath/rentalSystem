package view;

import javax.swing.*;
import java.awt.*;

public class UpdateMaintenance extends JDialog {
    private JPanel UpdateMaintenancePanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblUpdateMaintenance;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomType;
    private JLabel lblFillRoomType;
    private JLabel lblMaintenanceDate;
    private JTextField tFieldMDate;
    private JLabel lblMaintenanceTime;
    private JTextField tFieldMTime;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JComboBox comboBoxStatus;
    private JTextArea textAreaNote;
    private JLabel lblMNote;

    public UpdateMaintenance(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(UpdateMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,600));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        UpdateMaintenance updateMaintenance = new UpdateMaintenance(null);
    }

}
