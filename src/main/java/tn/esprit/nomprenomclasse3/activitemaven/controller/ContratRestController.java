package tn.esprit.nomprenomclasse3.activitemaven.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.nomprenomclasse3.activitemaven.entities.Contrat;
import tn.esprit.nomprenomclasse3.activitemaven.services.IContratServices;
import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratRestController {
    private final IContratServices service;

    @PostMapping
    public Contrat create(@RequestBody Contrat entity) {
        return service.add(entity);
    }

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Contrat update(@RequestBody Contrat entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Contrat> findAll() {
        return service.findAll();
    }
}
