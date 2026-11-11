package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Vehicule;
import java.util.List;

public interface IVehiculeServices {
    Vehicule getById(Long id);
    Vehicule add(Vehicule entity);
    Vehicule update(Vehicule entity);
    void deleteById(Long id);
    List<Vehicule> findAll();
}
