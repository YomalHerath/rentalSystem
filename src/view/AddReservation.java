package view;

import com.toedter.calendar.JDateChooser;
import controller.Reservation.ReservationImplement;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddReservation extends JFrame {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddReservation;
    private JPanel JPanel3;
    private JLabel lblClientName;
    private JTextField tFieldClientName;
    private JButton btnSave;
    private JButton btnCancel;
    private JPanel AddReservationPanel;
    private JLabel lblClientContactNo;
    private JTextField tFieldContactNo;
    private JComboBox comboBoxOccation;
    private JTextArea textAreaNote;
    private JLabel lblNote;
    private JLabel lblOccation;
    private JLabel lblReservedTime;
    private JLabel lblReservedDate;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomNo;
    private JSpinner spinnerTime;
    private JComboBox comboBoxTimeSelect;
    private JPanel fromDatePanel;
    private JPanel toDatePanel;
    private JSpinner spinnerEndTime;

    public AddReservation(String roomNo) {
        super();
        setTitle("Room Rental System");
        setContentPane(AddReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400, 700));
        //display dialog in the middle of the frame
        setLocationRelativeTo(AddReservationPanel);
        setResizable(false);
        setVisible(true);

        //set database value to text fields
        lblFillRoomNo.setText(roomNo);

        //view calender on JPanel
        Calendar calendar = Calendar.getInstance();
        JDateChooser fromdateChooser = new JDateChooser(calendar.getTime()); //initializing the calendar
        fromdateChooser.setDateFormatString("yyyy-MM-dd");
        fromDatePanel.add(fromdateChooser); //adding the calendar component to JPanel

        JDateChooser todateChooser = new JDateChooser(calendar.getTime()); //initializing the calendar
        todateChooser.setDateFormatString("yyyy-MM-dd");
        toDatePanel.add(todateChooser); //adding the calendar component to JPanel

        //set data picker font size
        Font font = new Font("Fira Code", Font.PLAIN, 16);
        fromdateChooser.setFont(font);
        todateChooser.setFont(font);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ManageRooms manageRooms = new ManageRooms();
                manageRooms.Load();
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get text field values
                String clientName = tFieldClientName.getText().trim();
                String clientContactNo = tFieldContactNo.getText().trim();
                String occasion = comboBoxOccation.getSelectedItem().toString();
                Date sdate = fromdateChooser.getDate();
                Date edate = todateChooser.getDate();
                String am_pm = comboBoxTimeSelect.getSelectedItem().toString();
                int stime = (Integer) spinnerTime.getValue();
                int endtime = (Integer) spinnerEndTime.getValue();
                String note = textAreaNote.getText().trim();

                if (clientName.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldClientName, "Enter Client Name", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (clientContactNo.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldContactNo, "Enter Client Contact No", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (stime <= 0) {
                    JOptionPane.showMessageDialog(spinnerTime, "Select Valid Time", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (endtime <= 0) {
                    JOptionPane.showMessageDialog(spinnerEndTime, "Select Valid Time", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Reservation reservation = new Reservation();

                    //set text
                    reservation.setClientName(clientName);
                    reservation.setClientContact(clientContactNo);
                    reservation.setOccasion(occasion);
                    reservation.setStartDate(sdate);
                    reservation.setEndDate(edate);
                    reservation.setTimeOfDay(am_pm);
                    reservation.setStime(stime);
                    reservation.setEtime(endtime);
                    reservation.setNote(note);
                    reservation.setRoomNo(roomNo);

                    // Create a new ExecutorService with a fixed pool of threads
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.submit(new Runnable() {
                        public void run() {
                            try {

                                // Save the reservation
                                ReservationImplement reservationImplement = new ReservationImplement();
                                reservationImplement.save(reservation);

                                // close the window and view manage reservation window
                                dispose();
                                ManageReservation manageReservation = new ManageReservation();
                                manageReservation.setVisible(true);


                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    executor.shutdown();

                }

            }
        });


    }

    public static void main(String[] args) {
    }
}

