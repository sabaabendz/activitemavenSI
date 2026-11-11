package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Maintenance;
import java.util.List;

public interface IMaintenanceServices {
    Maintenance getById(Long id);
    Maintenance add(Maintenance entity);
    Maintenance update(Maintenance entity);
    void deleteById(Long id);
    List<Maintenance> findAll();
}
