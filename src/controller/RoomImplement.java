package controller;

import database.DBConnection;
import model.Room;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class RoomImplement implements RoomInterface {
    @Override
    public void save(Room room) {
        try {
            Connection con =  DBConnection.getConnection();
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

    }

    @Override
    public Room get(int roomId) {
        return null;
    }

    @Override
    public List<Room> list() {
        return null;
    }
}
