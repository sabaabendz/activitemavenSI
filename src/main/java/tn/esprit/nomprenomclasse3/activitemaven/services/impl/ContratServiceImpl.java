package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Contrat;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IContratRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IContratServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ContratServiceImpl implements IContratServices {
    private final IContratRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Contrat getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat not found with id: " + id));
    }

    @Override
    public Contrat add(Contrat entity) {
        return repository.save(entity);
    }

    @Override
    public Contrat update(Contrat entity) {
        if (entity.getIdContrat() == null) {
            throw new IllegalArgumentException("An id is required to update a Contrat.");
        }
        if (!repository.existsById(entity.getIdContrat())) {
            throw new EntityNotFoundException("Contrat not found with id: " + entity.getIdContrat());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Contrat not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contrat> findAll() {
        return repository.findAll();
    }
}

