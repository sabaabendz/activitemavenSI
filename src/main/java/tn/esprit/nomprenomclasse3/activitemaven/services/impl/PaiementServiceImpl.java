package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Paiement;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IPaiementRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IPaiementServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaiementServiceImpl implements IPaiementServices {
    private final IPaiementRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Paiement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement not found with id: " + id));
    }

    @Override
    public Paiement add(Paiement entity) {
        return repository.save(entity);
    }

    @Override
    public Paiement update(Paiement entity) {
        if (entity.getIdPaiement() == null) {
            throw new IllegalArgumentException("An id is required to update a Paiement.");
        }
        if (!repository.existsById(entity.getIdPaiement())) {
            throw new EntityNotFoundException("Paiement not found with id: " + entity.getIdPaiement());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Paiement not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paiement> findAll() {
        return repository.findAll();
    }
}

