package view;

import controller.ClerkImplement;
import model.Clerk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

public class ManageClerks extends JFrame {
    private JPanel ManageClerksPanel;
    private JPanel JPanel2;
    private JLabel lblManageClerks;
    private JButton btnAddClerks;
    private JTextField tFieldClerksId;
    private JButton btnUpdateClerks;
    private JTable tableClerksDetails;

    //setup view of frame
    public ManageClerks() {
        super();
        setTitle("Room Rental System");
        setContentPane(ManageClerksPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(1280, 720));
        //display dialog in the middle of the frame
        setLocationRelativeTo(ManageClerksPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //update btn function call
        btnUpdateClerks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pass clerk id to update form
                String clerkId = tFieldClerksId.getText().trim();

                //validate field
                if (clerkId.isEmpty()) {
                    JOptionPane.showMessageDialog(tFieldClerksId, "Enter Clerk Id", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    //pass clerk id and view form
                    int passing_ClerkId = Integer.parseInt(clerkId);
                    UpdateClerk updateClerk = new UpdateClerk(passing_ClerkId);
                    dispose();
                }
            }
        });

        //add btn function call
        btnAddClerks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddClerk addClerk = new AddClerk();
                dispose();
            }
        });
    }

    //create a method for view data in table view
    public void Load() {

        //create clerk implementation object
        ClerkImplement clerkImplement = new ClerkImplement();
        //define column Names
        String[] columnNames = {"Clerk Id", "Full Name", "Username", "Email"};

        //store data into jTable
        List<Clerk> list = clerkImplement.list();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableClerksDetails.getModel();
        defaultTableModel.setColumnIdentifiers(columnNames);
        defaultTableModel.setRowCount(0);

        //add header color and font style in table
        JTableHeader header = tableClerksDetails.getTableHeader();
        header.setBackground(Color.BLUE);
        header.setForeground(Color.WHITE);
        Font font = new Font("Fira Code", Font.BOLD, 16);
        header.setFont(font);

        //fill table raws with database values by model class
        for (Clerk clerk : list) {
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
