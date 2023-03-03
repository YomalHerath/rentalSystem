package view;

import controller.Reservation.ReservationImplement;
import model.Reservation;

import javax.swing.*;
import java.awt.*;

public class UpdateReservation extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddReservation;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JLabel lblClientName;
    private JTextField tFieldClientName;
    private JLabel lblClientContactNo;
    private JTextField tFieldContactNo;
    private JLabel lblNote;
    private JTextArea textAreaNote;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JPanel UpdateReservationPanel;
    private JLabel lblOccation;
    private JComboBox comboBoxOccation;
    private JLabel lblReservedDate;
    private JTextField tFiieldFromDate;
    private JTextField tFieldRToDate;
    private JLabel lblReservedTime;
    private JSpinner spinnerTime;
    private JComboBox comboBoxTimeSelect;
    private JSpinner spinnerEndTime;
    private JComboBox comboBoxStatus;

    public UpdateReservation(String reservationId){
        super();
        setTitle("Room Rental System");
        setContentPane(UpdateReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,760));
        //display dialog in the middle of the frame
        setLocationRelativeTo(UpdateReservationPanel);
        setResizable(false);
        setVisible(true);

        // create object in Implement class
        ReservationImplement reservationImplement = new ReservationImplement();
        //call get function for retrieve data
        Reservation reservation = reservationImplement.get(reservationId);

        //set database value to text fields
        lblFillRoomNo.setText(reservation.getRoomNo());
        tFieldClientName.setText(reservation.getClientName());
        tFieldContactNo.setText(reservation.getClientContact());
        comboBoxOccation.setSelectedItem(reservation.getOccasion());

        java.util.Date utilDate = reservation.getStartDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        tFiieldFromDate.setText(sqlDate.toString());

        java.util.Date utilDate1 = reservation.getEndDate();
        java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
        tFieldRToDate.setText(sqlDate1.toString());

        spinnerTime.setValue(reservation.getStime());
        spinnerEndTime.setValue(reservation.getEtime());

        comboBoxTimeSelect.setSelectedItem(reservation.getTimeOfDay());
        comboBoxStatus.setSelectedItem(reservation.getStatus());
        textAreaNote.setText(reservation.getNote());

        int id = reservation.getReservationId();

    }

    public static void main(String[] args) {
    }
}
