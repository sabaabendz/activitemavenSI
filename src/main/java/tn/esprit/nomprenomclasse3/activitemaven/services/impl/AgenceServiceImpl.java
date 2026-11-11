package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Agence;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IAgenceRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IAgenceServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AgenceServiceImpl implements IAgenceServices {
    private final IAgenceRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Agence getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence not found with id: " + id));
    }

    @Override
    public Agence add(Agence entity) {
        return repository.save(entity);
    }

    @Override
    public Agence update(Agence entity) {
        if (entity.getIdAgence() == null) {
            throw new IllegalArgumentException("An id is required to update a Agence.");
        }
        if (!repository.existsById(entity.getIdAgence())) {
            throw new EntityNotFoundException("Agence not found with id: " + entity.getIdAgence());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Agence not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Agence> findAll() {
        return repository.findAll();
    }
}

