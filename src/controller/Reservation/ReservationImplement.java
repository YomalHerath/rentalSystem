package controller.Reservation;

import database.DBConnection;
import model.Reservation;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReservationImplement implements ReservationInterface {
    @Override
    public void save(Reservation reservation) {
        try {

            Connection con =  DBConnection.getConnection();
            String query = "INSERT INTO reservation(clientName,clientContact,Occation,fromDate,toDate,reservedTime,endTime,timeOfDay,note,roomNo) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, reservation.getClientName());
            preparedStatement.setString(2, reservation.getClientContact());
            preparedStatement.setString(3, reservation.getOccasion());

            preparedStatement.setString(4, reservation.getStartDate());

            preparedStatement.setString(5, reservation.getEndDate());

            preparedStatement.setInt(6, reservation.getStime());
            preparedStatement.setInt(7, reservation.getEtime());
            preparedStatement.setString(8, reservation.getTimeOfDay());
            preparedStatement.setString(9, reservation.getNote());
            preparedStatement.setString(10, reservation.getRoomNo());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Reservation reservation) {

    }

    @Override
    public void remove(Reservation reservation) {

    }

    @Override
    public Reservation get(int reservationId) {
        return null;
    }

    @Override
    public List<Reservation> list() {
        return null;
    }
}
