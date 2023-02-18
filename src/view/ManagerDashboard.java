package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ManagerDashboard extends JFrame {
    private JPanel ManagerPanel;
    private JButton manageRoomsButton;
    private JButton manageReservationsButton;
    private JButton manageMaintenanceButton;
    private JButton manageClerksButton;

    public ManagerDashboard(){
        super();
        setTitle("Room Rental System");
        setContentPane(ManagerPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ManagerPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        manageRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageRooms manageRooms = new ManageRooms();
                manageRooms.setVisible(true);
            }
        });
    }

    public void close(){
        WindowEvent windowEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
    }

    public static void main(String[] args) {
        ManagerDashboard managerDashboard = new ManagerDashboard();
    }
}
