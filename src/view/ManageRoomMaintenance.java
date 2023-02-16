package view;

import javax.swing.*;
import java.awt.*;

public class ManageRoomMaintenance extends JDialog {
    private JPanel ManageMaintenancePanel;
    private JPanel JPanel2;
    private JLabel lblManageMaintenance;
    private JButton btnAddMaintenance;
    private JTextField tFieldSearch;
    private JButton btnSearch;
    private JTable tableReservationDetails;
    private JScrollPane tableMaintenanceDetails;
    private JTextField tFieldMaintenanceId;
    private JButton btnUpdateMaintenance;

    public ManageRoomMaintenance(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(ManageMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManageRoomMaintenance manageRoomMaintenance = new ManageRoomMaintenance(null);
    }
}
