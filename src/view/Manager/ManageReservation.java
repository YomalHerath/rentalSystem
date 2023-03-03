package view.Manager;

import controller.Reservation.ReservationImplement;
import model.Reservation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class ManageReservation extends JFrame{
    private JPanel JPanel2;
    private JLabel lblManageRoom;
    private JTextField tFieldReservationSearch;
    private JButton btnReservationSearch;
    private JTable tableReservationDetails;
    private JPanel ManageReservationPanel;
    private JButton btnUpdateReservation;
    private JTextField tFieldReservationId;

    private String[] data;

    // create heading for table with create table method
    void createTable() {
        tableReservationDetails.setModel(new DefaultTableModel(
                null,
                new String[]{
                         "Reservation Id", "Room No", "Client Name", "Client Contact No", "Occasion", "Start Date", "End Date", "Start Time" , "End Time" , "Time of Date", "Note", "Status"
                }
        ));
    }

    //create a method for view data in table view
    public void Load() {

        //create room implementation object
        ReservationImplement reservationImplement = new ReservationImplement();
        //define column Names
        String[] columnNames = {"Reservation Id", "Room No", "Client Name", "Client Contact No", "Occasion", "Start Date", "End Date", "Start Time" , "End Time" , "Time of Date", "Note", "Status"};

        //store data into jTable
        List<Reservation> list = reservationImplement.list();
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
        for (Reservation reservation : list) {
            int reservationId = reservation.getReservationId();
            String roomNo = reservation.getRoomNo();
            String clientName = reservation.getClientName();
            String clientContact = reservation.getClientContact();
            String occasion = reservation.getOccasion();
            Date fromDate = reservation.getStartDate();
            Date endDate = reservation.getEndDate();
            String reservedTime = String.valueOf(reservation.getStime());
            String endTime = String.valueOf(reservation.getEtime());
            String timeOfDay = reservation.getTimeOfDay();
            String status = reservation.getStatus();
            String note = reservation.getNote();
            defaultTableModel.addRow(new Object[]{reservationId, roomNo, clientName, clientContact, occasion, fromDate, endDate, reservedTime, endTime,timeOfDay,note, status});
        }

    }

    public ManageReservation(){
        super();
        setTitle("Room Rental System");
        setContentPane(ManageReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ManageReservationPanel);
        setVisible(true);
        btnUpdateReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pass clerk id to update form
                String reservationId = tFieldReservationId.getText().trim();

                //validate text field
                if (reservationId.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter Reservation Id");
                }

                //validate field
                if (reservationId.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldReservationId, "Enter Reservation Id", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //pass clerk id and view form
                    String pass_reservation_id = reservationId;
                    UpdateReservation updateReservation = new UpdateReservation(pass_reservation_id);
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {

        ManageReservation manageReservationDetails = new ManageReservation();
        manageReservationDetails.Load();
    }
}
