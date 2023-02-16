package view;

import javax.swing.*;
import java.awt.*;

public class AddReservation extends JDialog {
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
    private JTextField tFieldRDate;
    private JTextField tFieldRTime;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomNo;
    private JLabel lblRoomType;
    private JLabel lblFillRoomType;

    public AddReservation(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(AddReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,720));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        AddReservation addReservation = new AddReservation(null);
    }
}

