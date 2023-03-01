package view;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import controller.Reservation.ReservationImplement;
import controller.room.RoomImplement;
import model.Reservation;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

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

    public AddReservation(String roomNo){
        super();
        setTitle("Room Rental System");
        setContentPane(AddReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,700));
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
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get text field values
                String clientName = tFieldClientName.getText().trim();
                String clientContactNo = tFieldContactNo.getText().trim();
                String occasion = comboBoxOccation.getSelectedItem().toString();
                String sdate = String.valueOf(fromdateChooser.getDate());
                String edate = String.valueOf(todateChooser.getDate());
                String am_pm = comboBoxTimeSelect.toString();
                int stime = (Integer) spinnerTime.getValue();
                int endtime = (Integer) spinnerEndTime.getValue();
                String note = textAreaNote.getText().trim();

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

                ReservationImplement reservationImplement = new ReservationImplement();
                reservationImplement.save(reservation);
            }
        });
    }

    public static void main(String[] args) {
        new AddReservation("1237").setVisible(true);
    }
}

