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
import tn.esprit.nomprenomclasse3.activitemaven.entities.Vehicule;
import tn.esprit.nomprenomclasse3.activitemaven.services.IVehiculeServices;
import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeRestController {
    private final IVehiculeServices service;

    @PostMapping
    public Vehicule create(@RequestBody Vehicule entity) {
        return service.add(entity);
    }

    @GetMapping("/{id}")
    public Vehicule getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Vehicule update(@RequestBody Vehicule entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Vehicule> findAll() {
        return service.findAll();
    }
}
