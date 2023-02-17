package view;

import controller.ClerkImplement;
import model.Clerk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ManageClerks extends JFrame {
    private JPanel ManageClerksPanel;
    private JPanel JPanel2;
    private JLabel lblManageClerks;
    private JButton btnAddClerks;
    private JTextField tFieldClerksSearch;
    private JButton btnClerksSearch;
    private JTextField tFieldClerksId;
    private JButton btnUpdateClerks;
    private JTable tableClerksDetails;

    public ManageClerks(){
        super();
        setTitle("Room Rental System");
        setContentPane(ManageClerksPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280,720));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ManageClerksPanel);
        setVisible(true);
    }

    public void Load()
    {
        ClerkImplement clerkImplement = new ClerkImplement();
        List<Clerk> list = clerkImplement.list();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableClerksDetails.getModel();
        defaultTableModel.setRowCount(0);
        for(Clerk clerk: list)
        {
            int clerkId = clerk.getClerkId();
            String fullName = clerk.getFullName();
            String username = clerk.getUsername();
            String email = clerk.getEmail();
            String password = clerk.getPassword();
            defaultTableModel.addRow(new Object[]{clerkId, fullName, username, email, password});
        }

    }

    public static void main(String[] args) {
        ManageClerks manageClerks = new ManageClerks();
        manageClerks.Load();
    }
}
