
package tn.esprit.nomprenomclasse3.activitemaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Agence;

public interface IAgenceRepository
        extends JpaRepository<Agence, Long> {
}
