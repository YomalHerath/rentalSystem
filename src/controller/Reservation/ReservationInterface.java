package controller.Reservation;

import model.Reservation;

import java.util.List;

public interface ReservationInterface {
    public void save(Reservation reservation);

    public void update(Reservation reservation);

    public void remove(Reservation reservation);

    public Reservation get(int reservationId);

    public List<Reservation> list();
}
