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
import tn.esprit.nomprenomclasse3.activitemaven.entities.Equipement;
import tn.esprit.nomprenomclasse3.activitemaven.services.IEquipementServices;
import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementRestController {
    private final IEquipementServices service;

    @PostMapping
    public Equipement create(@RequestBody Equipement entity) {
        return service.add(entity);
    }

    @GetMapping("/{id}")
    public Equipement getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Equipement update(@RequestBody Equipement entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Equipement> findAll() {
        return service.findAll();
    }
}
