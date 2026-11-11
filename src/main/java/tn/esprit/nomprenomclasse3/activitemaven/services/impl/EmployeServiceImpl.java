package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Employe;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IEmployeRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IEmployeServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeServiceImpl implements IEmployeServices {
    private final IEmployeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Employe getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe not found with id: " + id));
    }

    @Override
    public Employe add(Employe entity) {
        return repository.save(entity);
    }

    @Override
    public Employe update(Employe entity) {
        if (entity.getIdEmploye() == null) {
            throw new IllegalArgumentException("An id is required to update a Employe.");
        }
        if (!repository.existsById(entity.getIdEmploye())) {
            throw new EntityNotFoundException("Employe not found with id: " + entity.getIdEmploye());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Employe not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employe> findAll() {
        return repository.findAll();
    }
}

