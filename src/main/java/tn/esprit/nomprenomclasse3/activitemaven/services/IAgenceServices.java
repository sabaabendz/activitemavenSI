package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Agence;
import java.util.List;

public interface IAgenceServices {
    Agence getById(Long id);
    Agence add(Agence entity);
    Agence update(Agence entity);
    void deleteById(Long id);
    List<Agence> findAll();
}
