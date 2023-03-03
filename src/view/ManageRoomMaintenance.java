package view;

import controller.Maintenance.MaintenanceImplement;
import model.Maintenance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageRoomMaintenance extends JFrame {
    private JPanel ManageMaintenancePanel;
    private JPanel JPanel2;
    private JLabel lblManageMaintenance;
    private JTextField tFieldSearch;
    private JButton btnSearch;
    private JTable tableReservationDetails;
    private JScrollPane tableMaintenanceDetails;
    private JTextField tFieldMaintenanceId;
    private JButton btnUpdateMaintenance;
    private String[] data;

    // create heading for table with create table method
    void createTable() {
        tableReservationDetails.setModel(new DefaultTableModel(
                null,
                new String[]{
                        "Maintenance Id", "Room No", "Occasion", "Start Date", "End Date", "Note", "Status"
                }
        ));
    }

    public ManageRoomMaintenance(){
        super();
        setTitle("Room Rental System");
        setContentPane(ManageMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ManageMaintenancePanel);
        setVisible(true);
        btnUpdateMaintenance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pass clerk id to update form
                String mid = tFieldMaintenanceId.getText().trim();

                //validate field
                if (mid.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldMaintenanceId, "Enter Maintenance Id", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //pass clerk id and view form
                    String passing_mid = mid;
                    UpdateMaintenance updateMaintenance = new UpdateMaintenance(passing_mid);
                    dispose();
                }
            }
        });
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
        header.setBackground(Color.BLUE);
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

    public static void main(String[] args) {
        ManageRoomMaintenance manageRoomMaintenance = new ManageRoomMaintenance();
        manageRoomMaintenance.Load();
    }
}
