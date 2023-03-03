package view.Manager;

import controller.Reservation.ReservationImplement;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private JSpinner spinnerTime;
    private JComboBox comboBoxTimeSelect;
    private JSpinner spinnerEndTime;
    private JComboBox comboBoxStatus;

    public UpdateReservation(String reservationId) {
        super();
        setTitle("Room Rental System");
        setContentPane(UpdateReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400, 760));
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

        spinnerTime.setValue(reservation.getStime());
        spinnerEndTime.setValue(reservation.getEtime());

        comboBoxTimeSelect.setSelectedItem(reservation.getTimeOfDay());
        comboBoxStatus.setSelectedItem(reservation.getStatus());
        textAreaNote.setText(reservation.getNote());

        int id = reservation.getReservationId();
        String clientName = tFieldClientName.getText();
        String clientNo = tFieldContactNo.getText();
        String occasion = comboBoxOccation.getSelectedItem().toString();
        int stime = Integer.parseInt(spinnerTime.getValue().toString());
        int etime = Integer.parseInt(spinnerEndTime.getValue().toString());
        String timeofDate = comboBoxTimeSelect.getSelectedItem().toString();
        String status = comboBoxStatus.getSelectedItem().toString();
        String note = textAreaNote.getText();

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new ExecutorService with a fixed pool of threads
                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.submit(new Runnable() {
                    public void run() {
                        try {

                            reservation.setReservationId(id);
                            reservation.setClientName(clientName);
                            reservation.setClientContact(clientNo);
                            reservation.setOccasion(occasion);
                            reservation.setStime(stime);
                            reservation.setEtime(etime);
                            reservation.setTimeOfDay(timeofDate);
                            reservation.setStatus(status);
                            reservation.setNote(note);

                            ReservationImplement reservationImplement1 = new ReservationImplement();
                            reservationImplement.update(reservation);
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
            }
        });
    }

    public static void main(String[] args) {
    }
}
