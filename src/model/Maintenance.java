package model;

public class Maintenance {

    private int Maintenance_id;
    private String RoomNo;
    private String Occasion;
    private String StartDate;
    private String EndDate;
    private String Note;

    public int getMaintenance_id() {
        return Maintenance_id;
    }

    public void setMaintenance_id(int maintenance_id) {
        Maintenance_id = maintenance_id;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getOccasion() {
        return Occasion;
    }

    public void setOccasion(String occasion) {
        Occasion = occasion;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "Maintenance_id=" + Maintenance_id +
                ", RoomNo='" + RoomNo + '\'' +
                ", Occasion='" + Occasion + '\'' +
                ", StartDate='" + StartDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", Note='" + Note + '\'' +
                '}';
    }
}
