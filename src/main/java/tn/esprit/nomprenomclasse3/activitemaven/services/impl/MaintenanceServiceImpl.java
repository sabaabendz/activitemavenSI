package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Maintenance;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IMaintenanceRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IMaintenanceServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MaintenanceServiceImpl implements IMaintenanceServices {
    private final IMaintenanceRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Maintenance getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance not found with id: " + id));
    }

    @Override
    public Maintenance add(Maintenance entity) {
        return repository.save(entity);
    }

    @Override
    public Maintenance update(Maintenance entity) {
        if (entity.getIdMaintenance() == null) {
            throw new IllegalArgumentException("An id is required to update a Maintenance.");
        }
        if (!repository.existsById(entity.getIdMaintenance())) {
            throw new EntityNotFoundException("Maintenance not found with id: " + entity.getIdMaintenance());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Maintenance not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maintenance> findAll() {
        return repository.findAll();
    }
}

