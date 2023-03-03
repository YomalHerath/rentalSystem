package controller.Reservation;

import database.DBConnection;
import model.Reservation;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationImplement {
    public void save(Reservation reservation) {

        Thread thread = new Thread(() -> {
            try {
                Connection conn = null;
                PreparedStatement pstmt = null;
                conn = DBConnection.getConnection();
                String sql = "INSERT INTO reservation (roomNo, clientName, clientContact, occasion, fromDate, toDate, reservedTime, endtime, timeOfDay, note) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, reservation.getRoomNo());
                pstmt.setString(2, reservation.getClientName());
                pstmt.setString(3, reservation.getClientContact());
                pstmt.setString(4, reservation.getOccasion());

                if (reservation.getStartDate() != null) {
                    java.util.Date fromDate = reservation.getStartDate();
                    java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
                    pstmt.setDate(5, sqlFromDate);
                } else {
                    pstmt.setNull(5, java.sql.Types.DATE);
                }

                if (reservation.getEndDate() != null) {
                    java.util.Date toDate = reservation.getEndDate();
                    java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
                    pstmt.setDate(6, sqlToDate);
                } else {
                    pstmt.setNull(6, java.sql.Types.DATE);
                }

                pstmt.setInt(7, reservation.getStime());
                pstmt.setInt(8, reservation.getEtime());
                pstmt.setString(9, reservation.getTimeOfDay());
                pstmt.setString(10, reservation.getNote());
                pstmt.executeUpdate();

                //update the room table as unavailable
                String sql2 = "UPDATE room SET availability = 'Unavailable', status = 'Booked' WHERE roomNo = '" + reservation.getRoomNo() + "'";

                Statement statement = conn.createStatement();
                pstmt.execute(sql2);

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();
    }


    public void update(Reservation reservation) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "UPDATE reservation SET clientName=?, clientContact=?, Occasion=? ,reservedTime=?, endTime=?, timeOfDay=?, note=?, status=? WHERE reservationId=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, reservation.getClientName());
                ps.setString(2, reservation.getClientContact());
                ps.setString(3, reservation.getOccasion());
                ps.setInt(4, reservation.getStime());
                ps.setInt(5, reservation.getEtime());
                ps.setString(6, reservation.getTimeOfDay());
                ps.setString(7, reservation.getNote());
                ps.setString(8, reservation.getStatus());
                ps.setInt(9, reservation.getReservationId());
                ps.executeUpdate();

                String occasion = reservation.getOccasion();

                if (occasion.equals("Completed") || occasion.equals("Canceled")){
                    //update the room table as available
                    String sql2 = "UPDATE room SET availability = 'Available', status = 'Booked' WHERE roomNo = '" + reservation.getRoomNo() + "'";
                    Statement statement = con.createStatement();
                    statement.executeUpdate(sql2);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }



    public Reservation get(String reservationId) {
        Reservation reservation = new Reservation();
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * FROM reservation WHERE reservationId=?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, reservationId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    reservation.setRoomNo(resultSet.getString("roomNo"));
                    reservation.setClientName(resultSet.getString("clientName"));
                    reservation.setClientContact(resultSet.getString("clientContact"));
                    reservation.setOccasion(resultSet.getString("Occasion"));
                    reservation.setStartDate(resultSet.getDate("fromDate"));
                    reservation.setEndDate(resultSet.getDate("toDate"));
                    reservation.setStime(resultSet.getInt("reservedTime"));
                    reservation.setEtime(resultSet.getInt("endTime"));
                    reservation.setTimeOfDay(resultSet.getString("timeOfDay"));
                    reservation.setNote(resultSet.getString("note"));
                    reservation.setStatus(resultSet.getString("status"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public List<Reservation> list() {
        List<Reservation> list = new ArrayList<Reservation>();
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * FROM reservation";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                //data will be added until finish
                while (resultSet.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setReservationId(resultSet.getInt("reservationId"));
                    reservation.setRoomNo(resultSet.getString("roomNo"));
                    reservation.setClientName(resultSet.getString("clientName"));
                    reservation.setClientContact(resultSet.getString("clientContact"));
                    reservation.setOccasion(resultSet.getString("Occasion"));
                    reservation.setStartDate(resultSet.getDate("fromDate"));
                    reservation.setEndDate(resultSet.getDate("toDate"));
                    reservation.setStime(resultSet.getInt("reservedTime"));
                    reservation.setEtime(resultSet.getInt("endTime"));
                    reservation.setTimeOfDay(resultSet.getString("timeOfDay"));
                    reservation.setNote(resultSet.getString("note"));
                    reservation.setStatus(resultSet.getString("status"));
                    list.add(reservation);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;

    }
}
