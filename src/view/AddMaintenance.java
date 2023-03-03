package view;

import controller.Maintenance.MaintenanceImplement;
import controller.Reservation.ReservationImplement;
import model.Maintenance;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddMaintenance extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddMaintenance;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JButton btnSave;
    private JButton btnCancel;
    private JPanel AddMaintenancePanel;
    private JLabel lblMaintenanceNote;
    private JLabel lblOccation;
    private JComboBox comboBoxOccation;
    private JLabel lblReservedDate;
    private JTextField tFiieldFromDate;
    private JTextField tFieldRToDate;
    private JComboBox comboBoxNote;

    public AddMaintenance(String roomNo){
        setTitle("Room Rental System");
        setContentPane(AddMaintenancePanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,550));
        //display dialog in the middle of the frame
        setLocationRelativeTo(AddMaintenancePanel);
        setVisible(true);

        //set database value to text fields
        lblFillRoomNo.setText(roomNo);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String occasion = comboBoxOccation.getSelectedItem().toString();
                String sDate = tFiieldFromDate.getText().trim();
                String eDate = tFieldRToDate.getText().trim();
                String note = comboBoxNote.getSelectedItem().toString();

                if (sDate.isEmpty()){
                    JOptionPane.showMessageDialog(tFieldRToDate, "Enter Full Name", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (eDate.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldRToDate, "Enter Full Name", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    Maintenance maintenance = new Maintenance();

                    maintenance.setRoomNo(roomNo);
                    maintenance.setOccasion(occasion);
                    maintenance.setStartDate(sDate);
                    maintenance.setEndDate(eDate);
                    maintenance.setNote(note);

                    // Create a new ExecutorService with a fixed pool of threads
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(new Runnable() {
                        public void run() {
                            try {

                                MaintenanceImplement maintenanceImplement = new MaintenanceImplement();
                                maintenanceImplement.save(maintenance);

                                dispose();
                                //call manage view page
                                ManageRoomMaintenance manageRoomMaintenance = new ManageRoomMaintenance();
                                manageRoomMaintenance.Load();


                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    executor.shutdown();
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManageRooms manageRooms = new ManageRooms();
                manageRooms.Load();
            }
        });
    }

    public static void main(String[] args) {
        AddMaintenance addMaintenance = new AddMaintenance(null);
    }
}
