
package tn.esprit.nomprenomclasse3.activitemaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Contrat;

public interface IContratRepository
        extends JpaRepository<Contrat, Long> {
}
