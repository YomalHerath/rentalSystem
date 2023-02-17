package view;

import javax.swing.*;
import java.awt.*;

public class AddMaintenance extends JDialog {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddMaintenance;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomType;
    private JLabel lblFillRoomType;
    private JButton btnSave;
    private JButton btnCancel;
    private JPanel AddMaintenancePanel;
    private JLabel lblMaintenanceNote;
    private JLabel lblOccation;
    private JComboBox comboBoxOccation;
    private JLabel lblReservedDate;
    private JTextField tFiieldFromDate;
    private JTextField tFieldRToDate;
    private JLabel lblReservedTime;
    private JSpinner spinnerTime;
    private JComboBox comboBoxTimeSelect;
    private JComboBox comboBoxNote;

    public AddMaintenance(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(AddMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,550));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        AddMaintenance addMaintenance = new AddMaintenance(null);
    }
}