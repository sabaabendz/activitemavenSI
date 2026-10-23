
package tn.esprit.nomprenomclasse3.activitemaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Equipement;

public interface IEquipementRepository
        extends JpaRepository<Equipement, Long> {
}
