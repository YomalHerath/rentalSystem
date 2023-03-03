package controller.room;

import database.DBConnection;
import model.Room;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomImplement {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void save(Room room) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String query = "INSERT INTO room(roomNo,roomType,roomSize) VALUES (?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, room.getRoomNo());
                preparedStatement.setString(2, room.getRoomType());
                preparedStatement.setInt(3, room.getRoomSize());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        thread.start();
    }

    public void update(Room room) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "UPDATE room SET roomNo=?, roomType=?, roomSize=?, availability=?, status=? WHERE roomId=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, room.getRoomNo());
                ps.setString(2, room.getRoomType());
                ps.setInt(3, room.getRoomSize());
                ps.setString(4, room.getRoomAvailability());
                ps.setString(5, room.getRoomStatus());
                ps.setInt(6, room.getRoomId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        thread.start();
    }

    public void delete(Room room) {
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "delete from room  WHERE roomNo=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, room.getRoomNo());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        thread.start();
    }

    public Room get(String roomNo) {
        Room room = new Room();
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * FROM room WHERE roomNo=?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, roomNo);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    room.setRoomId(resultSet.getInt("roomId"));
                    room.setRoomNo(resultSet.getString("roomNo"));
                    room.setRoomType(resultSet.getString("roomType"));
                    room.setRoomSize(resultSet.getInt("roomSize"));
                    room.setRoomAvailability(resultSet.getString("availability"));
                    room.setRoomStatus(resultSet.getString("status"));
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
        return room;
    }

    public List<Room> list() {
        List<Room> list = new ArrayList<Room>();
        Thread thread = new Thread(() -> {
            try {
                Connection con = DBConnection.getConnection();
                String sql = "SELECT * FROM room";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                //data will be added until finish
                while (resultSet.next()) {
                    Room room = new Room();
                    room.setRoomId(resultSet.getInt("roomId"));
                    room.setRoomNo(resultSet.getString("roomNo"));
                    room.setRoomType(resultSet.getString("roomType"));
                    room.setRoomSize(resultSet.getInt("roomSize"));
                    room.setRoomAvailability(resultSet.getString("availability"));
                    room.setRoomStatus(resultSet.getString("status"));
                    list.add(room);
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
