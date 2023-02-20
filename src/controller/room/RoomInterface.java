package controller.room;

import model.Clerk;
import model.Room;

import java.util.List;

public interface RoomInterface {
    public void save(Room room);
    public void update(Room room);
    public Room get (String roomId);
    public List<Room> list();
}
