package view;

import javax.swing.*;
import java.awt.*;

public class UpdateMaintenance extends JFrame {
    private JPanel UpdateMaintenancePanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblUpdateMaintenance;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomType;
    private JLabel lblFillRoomType;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JComboBox comboBoxStatus;
    private JLabel lblOccation;
    private JComboBox comboBoxOccation;
    private JLabel lblReservedDate;
    private JTextField tFiieldFromDate;
    private JTextField tFieldRToDate;
    private JLabel lblReservedTime;
    private JSpinner spinnerTime;
    private JComboBox comboBoxTimeSelect;
    private JLabel lblMaintenanceNote;
    private JComboBox comboBoxNote;

    public UpdateMaintenance(){
        super();
        setTitle("Room Rental System");
        setContentPane(UpdateMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,620));
        //display dialog in the middle of the frame
        setLocationRelativeTo(UpdateMaintenancePanel);
        setVisible(true);

    }

    public static void main(String[] args) {
        UpdateMaintenance updateMaintenance = new UpdateMaintenance();
    }

}
