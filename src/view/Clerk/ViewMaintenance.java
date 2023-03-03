package view.Clerk;

import controller.Maintenance.MaintenanceImplement;
import model.Maintenance;
import view.Manager.ManageRoomMaintenance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class ViewMaintenance extends JFrame {
    private JPanel ManageMaintenancePanel;
    private JPanel JPanel2;
    private JLabel lblManageMaintenance;
    private JTextField tFieldSearch;
    private JButton btnSearch;
    private JScrollPane tableMaintenanceDetails;
    private JTable tableReservationDetails;

    public ViewMaintenance() {
        super();
        setTitle("Room Rental System");
        setContentPane(ManageMaintenancePanel);
        setMinimumSize(new Dimension(1280, 720));
        setLocationRelativeTo(ManageMaintenancePanel);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        ViewMaintenance manageRoomMaintenance = new ViewMaintenance();
        manageRoomMaintenance.Load();
    }

    // create heading for table with create table method
    void createTable() {
        tableReservationDetails.setModel(new DefaultTableModel(null, new String[]{"Maintenance Id", "Room No", "Occasion", "Start Date", "End Date", "Note", "Status"}));
    }

    //create a method for view data in table view
    public void Load() {

        //create room implementation object
        MaintenanceImplement maintenanceImplement = new MaintenanceImplement();
        //define column Names
        String[] columnNames = {"Maintenance Id", "Room No", "Occasion", "Start Date", "End Date", "Note", "Status"};

        //store data into jTable
        List<Maintenance> list = maintenanceImplement.list();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableReservationDetails.getModel();
        defaultTableModel.setColumnIdentifiers(columnNames);
        defaultTableModel.setRowCount(0);

        //add header color and font style in table
        JTableHeader header = tableReservationDetails.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        Font font = new Font("Fira Code", Font.BOLD, 16);
        header.setFont(font);

        //fill table raws with database values by model class
        for (Maintenance maintenance : list) {
            String rId = maintenance.getMaintenance_id();
            String roomNo = maintenance.getRoomNo();
            String occasion = maintenance.getOccasion();
            String sDate = String.valueOf(maintenance.getStartDate());
            String eDate = maintenance.getEndDate();
            String Note = maintenance.getNote();
            String Status = maintenance.getStatus();
            defaultTableModel.addRow(new Object[]{rId, roomNo, occasion, sDate, eDate, Note, Status});
        }

    }
}
