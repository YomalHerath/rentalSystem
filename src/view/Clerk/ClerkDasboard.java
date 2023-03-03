package view.Clerk;

import view.Manager.ClerkDashboard;

import javax.swing.*;
import java.awt.*;

public class ClerkDasboard extends JFrame {
    private JPanel ClerkPanel;
    private JButton manageRoomsButton;
    private JButton manageClerksButton;
    private JButton manageReservationsButton;
    private JButton manageMaintenanceButton;

    public ClerkDasboard() {
        super();
        setTitle("Room Rental System");
        setContentPane(ClerkPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280, 720));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ClerkPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        ClerkDashboard clerkDashboard = new ClerkDashboard();
    }
}