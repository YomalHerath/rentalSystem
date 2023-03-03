package view.Clerk;

import view.Manager.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ClerkDasboard extends JFrame {
    private JPanel ClerkPanel;
    private JButton manageRoomsButton;
    private JButton manageClerksButton;
    private JButton manageReservationsButton;
    private JButton manageMaintenanceButton;

    public ClerkDasboard(){
        super();
        setTitle("Room Rental System");
        setContentPane(ClerkPanel);
        setMinimumSize(new Dimension(1280,720));
        setLocationRelativeTo(ClerkPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        manageRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRooms manageRooms = new ManageRooms();
                manageRooms.Load();
            }
        });
        manageClerksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageClerks manageClerks = new ManageClerks();
                manageClerks.Load();
            }
        });
        manageReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageReservation manageReservation = new ManageReservation();
                manageReservation.Load();
            }
        });
        manageMaintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRoomMaintenance manageRoomMaintenance = new ManageRoomMaintenance();
                manageRoomMaintenance.Load();
            }
        });
    }
    public void close(){
        WindowEvent windowEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
    }

    public static void main(String[] args) {
        ClerkDasboard clerkDasboard = new ClerkDasboard();
    }


}