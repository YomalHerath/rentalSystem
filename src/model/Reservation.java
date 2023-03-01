package model;

import java.util.Date;

public class Reservation {
    String roomNo;
    String clientName;
    String clientContact;
    String occasion;
    String startDate;
    String endDate;
    int stime;
    int etime;
    String timeOfDay;
    String note;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStime() {
        return stime;
    }

    public void setStime(int stime) {
        this.stime = stime;
    }

    public int getEtime() {
        return etime;
    }

    public void setEtime(int etime) {
        this.etime = etime;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomNo='" + roomNo + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientContact='" + clientContact + '\'' +
                ", occasion='" + occasion + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", stime=" + stime +
                ", etime=" + etime +
                ", timeOfDay='" + timeOfDay + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
