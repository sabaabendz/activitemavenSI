package tn.esprit.nomprenomclasse3.activitemaven.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Reservation;
import tn.esprit.nomprenomclasse3.activitemaven.repository.IReservationRepository;
import tn.esprit.nomprenomclasse3.activitemaven.services.IReservationServices;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationServiceImpl implements IReservationServices {
    private final IReservationRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Reservation getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
    }

    @Override
    public Reservation add(Reservation entity) {
        return repository.save(entity);
    }

    @Override
    public Reservation update(Reservation entity) {
        if (entity.getIdReservation() == null) {
            throw new IllegalArgumentException("An id is required to update a Reservation.");
        }
        if (!repository.existsById(entity.getIdReservation())) {
            throw new EntityNotFoundException("Reservation not found with id: " + entity.getIdReservation());
        }
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Reservation not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        return repository.findAll();
    }
}

