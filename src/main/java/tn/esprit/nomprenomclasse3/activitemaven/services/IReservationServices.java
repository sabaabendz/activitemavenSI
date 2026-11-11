package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Reservation;
import java.util.List;

public interface IReservationServices {
    Reservation getById(Long id);
    Reservation add(Reservation entity);
    Reservation update(Reservation entity);
    void deleteById(Long id);
    List<Reservation> findAll();
}
