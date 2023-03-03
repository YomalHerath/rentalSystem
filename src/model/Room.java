package model;

public class Room {

    private int roomId;
    private String roomNo;
    private String roomType;
    private int roomSize;
    private String roomAvailability;
    private String roomStatus;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Room(String roomNo, String roomType, int roomSize) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomSize = roomSize;
    }

    public Room(){}

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNo='" + roomNo + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomSize=" + roomSize +
                ", roomAvailability='" + roomAvailability + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
