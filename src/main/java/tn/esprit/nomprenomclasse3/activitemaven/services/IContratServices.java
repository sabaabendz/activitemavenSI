package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Contrat;
import java.util.List;

public interface IContratServices {
    Contrat getById(Long id);
    Contrat add(Contrat entity);
    Contrat update(Contrat entity);
    void deleteById(Long id);
    List<Contrat> findAll();
}
