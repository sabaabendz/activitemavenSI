package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Equipement;
import java.util.List;

public interface IEquipementServices {
    Equipement getById(Long id);
    Equipement add(Equipement entity);
    Equipement update(Equipement entity);
    void deleteById(Long id);
    List<Equipement> findAll();
}
