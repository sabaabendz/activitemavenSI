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
import tn.esprit.nomprenomclasse3.activitemaven.entities.Paiement;
import tn.esprit.nomprenomclasse3.activitemaven.services.IPaiementServices;
import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementRestController {
    private final IPaiementServices service;

    @PostMapping
    public Paiement create(@RequestBody Paiement entity) {
        return service.add(entity);
    }

    @GetMapping("/{id}")
    public Paiement getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Paiement update(@RequestBody Paiement entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Paiement> findAll() {
        return service.findAll();
    }
}
