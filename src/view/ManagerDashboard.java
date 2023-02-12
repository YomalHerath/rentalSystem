package view;

import javax.swing.*;
import java.awt.*;

public class ManagerDashboard extends JDialog {
    private JPanel ManagerDashboardPanel;
    private JButton btnReservations;
    private JButton btnRooms;
    private JButton btnEmployees;

    public ManagerDashboard(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(ManagerDashboardPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManagerDashboard dashboard = new ManagerDashboard(null);
    }

}
