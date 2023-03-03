package model;

public class Maintenance {

    private String Maintenance_id;
    private String RoomNo;
    private String Occasion;
    private String StartDate;
    private String EndDate;
    private String Note;
    private String status;

    public String getMaintenance_id() {
        return Maintenance_id;
    }

    public void setMaintenance_id(String maintenance_id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                ", status='" + status + '\'' +
                '}';
    }
}
