package view;

import controller.Maintenance.MaintenanceImplement;
import controller.Reservation.ReservationImplement;
import model.Maintenance;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UpdateMaintenance extends JFrame {
    private JPanel UpdateMaintenancePanel;
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblUpdateMaintenance;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JComboBox comboBoxStatus;
    private JLabel lblOccation;
    private JComboBox comboBoxOccation;
    private JLabel lblReservedDate;
    private JTextField tFiieldFromDate;
    private JTextField tFieldRToDate;
    private JLabel lblMaintenanceNote;
    private JComboBox comboBoxNote;

    public UpdateMaintenance(String mid){
        super();
        setTitle("Room Rental System");
        setContentPane(UpdateMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,620));
        //display dialog in the middle of the frame
        setLocationRelativeTo(UpdateMaintenancePanel);
        setResizable(false);
        setVisible(true);

        // create object in Implement class
        MaintenanceImplement maintenanceImplement = new MaintenanceImplement();
        //call get function for retrieve data
        Maintenance maintenance = maintenanceImplement.get(mid);

        //set values
        lblFillRoomNo.setText(maintenance.getRoomNo());
        comboBoxOccation.setSelectedItem(maintenance.getOccasion());
        tFiieldFromDate.setText(maintenance.getStartDate());
        tFieldRToDate.setText(maintenance.getEndDate());
        comboBoxNote.setSelectedItem(maintenance.getNote());
        comboBoxStatus.setSelectedItem(maintenance.getStatus());

        String occasion = comboBoxOccation.getSelectedItem().toString();
        String sdate = tFiieldFromDate.getText();
        String edate = tFieldRToDate.getText();
        String note = comboBoxNote.getSelectedItem().toString();
        String status = comboBoxStatus.getSelectedItem().toString();


        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new ExecutorService with a fixed pool of threads
                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.submit(new Runnable() {
                    public void run() {
                        try {

                            maintenance.setMaintenance_id(mid);
                            maintenance.setOccasion(occasion);
                            maintenance.setStartDate(sdate);
                            maintenance.setEndDate(edate);
                            maintenance.setNote(note);
                            maintenance.setStatus(status);

                            MaintenanceImplement maintenanceImplement1 = new MaintenanceImplement();
                            maintenanceImplement1.update(maintenance);

                            ManageRoomMaintenance manageRoomMaintenance = new ManageRoomMaintenance();
                            manageRoomMaintenance.Load();
                            dispose();

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                executor.shutdown();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManageRoomMaintenance manageRoomMaintenance = new ManageRoomMaintenance();
                manageRoomMaintenance.Load();
            }
        });
    }

    public static void main(String[] args) {
    }

}
