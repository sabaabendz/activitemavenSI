package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Equipement;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IEquipementRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IEquipementServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EquipementServiceImpl implements IEquipementServices {
    private final IEquipementRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Equipement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipement not found with id: " + id));
    }

    @Override
    public Equipement add(Equipement entity) {
        return repository.save(entity);
    }

    @Override
    public Equipement update(Equipement entity) {
        if (entity.getIdEquipement() == null) {
            throw new IllegalArgumentException("An id is required to update a Equipement.");
        }
        if (!repository.existsById(entity.getIdEquipement())) {
            throw new EntityNotFoundException("Equipement not found with id: " + entity.getIdEquipement());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Equipement not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipement> findAll() {
        return repository.findAll();
    }
}

