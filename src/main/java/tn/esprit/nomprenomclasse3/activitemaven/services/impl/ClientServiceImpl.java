package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Client;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IClientRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IClientServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements IClientServices {
    private final IClientRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Client getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + id));
    }

    @Override
    public Client add(Client entity) {
        return repository.save(entity);
    }

    @Override
    public Client update(Client entity) {
        if (entity.getIdClient() == null) {
            throw new IllegalArgumentException("An id is required to update a Client.");
        }
        if (!repository.existsById(entity.getIdClient())) {
            throw new EntityNotFoundException("Client not found with id: " + entity.getIdClient());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Client not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return repository.findAll();
    }
}

