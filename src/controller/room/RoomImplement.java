package controller.room;

import database.DBConnection;
import model.Clerk;
import model.Room;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomImplement implements RoomInterface {
    @Override
    public void save(Room room) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO room(roomNo,roomType,roomSIze) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, room.getRoomNo());
            preparedStatement.setString(2, room.getRoomType());
            preparedStatement.setInt(3, room.getRoomSize());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Room room) {
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
    }

    @Override
    public Room get(String roomNo) {
        Room room = new Room();
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
        return room;
    }

    @Override
    public List<Room> list() {
        List<Room> list = new ArrayList<Room>();
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
        return list;
    }
}
