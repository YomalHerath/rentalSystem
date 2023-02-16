package view;

import javax.swing.*;
import java.awt.*;

public class UpdateReservation extends JDialog {
    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lblAddReservation;
    private JPanel JPanel3;
    private JLabel lblRoomNo;
    private JLabel lblFillRoomNo;
    private JLabel lblRoomType;
    private JLabel lblFillRoomType;
    private JLabel lblClientName;
    private JTextField tFieldClientName;
    private JLabel lblClientContactNo;
    private JTextField tFieldContactNo;
    private JLabel lblReservedDate;
    private JTextField tFieldRDate;
    private JLabel lblReservedTime;
    private JTextField tFieldRTime;
    private JLabel lblOccation;
    private JComboBox comboBoxOccation;
    private JLabel lblNote;
    private JTextArea textAreaNote;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JPanel UpdateReservationPanel;

    public UpdateReservation(JFrame jFrame){
        super(jFrame);
        setTitle("Room Rental System");
        setContentPane(UpdateReservationPanel);
        //set minimum size for dialog
        setMinimumSize(new Dimension(400,760));
        setModal(true);
        //display dialog in the middle of the frame
        setLocationRelativeTo(jFrame);
        setVisible(true);

    }

    public static void main(String[] args) {
        UpdateReservation updateReservation = new UpdateReservation(null);
    }
}
