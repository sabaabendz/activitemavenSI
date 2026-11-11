package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Paiement;
import java.util.List;

public interface IPaiementServices {
    Paiement getById(Long id);
    Paiement add(Paiement entity);
    Paiement update(Paiement entity);
    void deleteById(Long id);
    List<Paiement> findAll();
}
