
package tn.esprit.nomprenomclasse3.activitemaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Employe;

public interface IEmployeRepository
        extends JpaRepository<Employe, Long> {
}
