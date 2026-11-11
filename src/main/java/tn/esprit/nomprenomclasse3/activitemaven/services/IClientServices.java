package tn.esprit.nomprenomclasse3.activitemaven.services;

import tn.esprit.nomprenomclasse3.activitemaven.entities.Client;
import java.util.List;

public interface IClientServices {
    Client getById(Long id);
    Client add(Client entity);
    Client update(Client entity);
    void deleteById(Long id);
    List<Client> findAll();
}
