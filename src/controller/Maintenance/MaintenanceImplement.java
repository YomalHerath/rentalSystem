package controller.Maintenance;

import database.DBConnection;
import model.Maintenance;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceImplement {
    public void save(Maintenance maintenance) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String query = "INSERT INTO maintenane(roomNo, occasion, startDate, endDate, Note) VALUES (?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, maintenance.getRoomNo());
                preparedStatement.setString(2, maintenance.getOccasion());
                preparedStatement.setString(3, maintenance.getStartDate());
                preparedStatement.setString(4, maintenance.getEndDate());
                preparedStatement.setString(5, maintenance.getNote());
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Saved!");

                //update the room table as unavailable
                String sql2 = "UPDATE room SET availability = 'Unavailable', status = 'Booked' WHERE roomNo = '" + maintenance.getRoomNo() + "'";

                Statement statement = con.createStatement();
                preparedStatement.execute(sql2);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Fail to insert maintenance" + e.getMessage());
            }
        });
        thread.start();
    }

    public void update(Maintenance maintenance) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "UPDATE maintenane SET occasion=?,startDate=?,endDate=?, Note=? WHERE m_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, maintenance.getOccasion());
                ps.setString(2, maintenance.getStartDate());
                ps.setString(3, maintenance.getEndDate());
                ps.setString(4, maintenance.getNote());
                ps.setString(5, maintenance.getMaintenance_id());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Fail to update maintenance" + e.getMessage());
            }
        });
        thread.start();
    }

    public Maintenance get(String maintenanceId) {
        Maintenance maintenance = new Maintenance();
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * FROM maintenane WHERE m_id=?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, maintenanceId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    maintenance.setMaintenance_id(resultSet.getString("m_id"));
                    maintenance.setRoomNo(resultSet.getString("roomNo"));
                    maintenance.setOccasion(resultSet.getString("occasion"));
                    maintenance.setStartDate(resultSet.getString("startDate"));
                    maintenance.setEndDate(resultSet.getString("endDate"));
                    maintenance.setNote(resultSet.getString("Note"));
                    maintenance.setStatus(resultSet.getString("status"));
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return maintenance;
    }

    public List<Maintenance> list() {
        List<Maintenance> list = new ArrayList<Maintenance>();
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * FROM maintenane";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                //data will be added until finish
                while (resultSet.next()) {
                    Maintenance maintenance = new Maintenance();
                    maintenance.setMaintenance_id(resultSet.getString("m_id"));
                    maintenance.setRoomNo(resultSet.getString("roomNo"));
                    maintenance.setOccasion(resultSet.getString("occasion"));
                    maintenance.setStartDate(resultSet.getString("startDate"));
                    maintenance.setEndDate(resultSet.getString("endDate"));
                    maintenance.setNote(resultSet.getString("Note"));
                    maintenance.setStatus(resultSet.getString("status"));
                    list.add(maintenance);
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
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
