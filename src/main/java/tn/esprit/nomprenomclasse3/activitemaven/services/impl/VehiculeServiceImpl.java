package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Vehicule;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IVehiculeRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IVehiculeServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehiculeServiceImpl implements IVehiculeServices {
    private final IVehiculeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Vehicule getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule not found with id: " + id));
    }

    @Override
    public Vehicule add(Vehicule entity) {
        return repository.save(entity);
    }

    @Override
    public Vehicule update(Vehicule entity) {
        if (entity.getIdVehicule() == null) {
            throw new IllegalArgumentException("An id is required to update a Vehicule.");
        }
        if (!repository.existsById(entity.getIdVehicule())) {
            throw new EntityNotFoundException("Vehicule not found with id: " + entity.getIdVehicule());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Vehicule not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicule> findAll() {
        return repository.findAll();
    }
}

