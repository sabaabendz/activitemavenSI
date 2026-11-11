package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Employe;
import java.util.List;

public interface IEmployeServices {
    Employe getById(Long id);
    Employe add(Employe entity);
    Employe update(Employe entity);
    void deleteById(Long id);
    List<Employe> findAll();
}
