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
import tn.esprit.nomprenomclasse3.activitemaven.entities.Maintenance;
import tn.esprit.nomprenomclasse3.activitemaven.services.IMaintenanceServices;
import java.util.List;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
public class MaintenanceRestController {
    private final IMaintenanceServices service;

    @PostMapping
    public Maintenance create(@RequestBody Maintenance entity) {
        return service.add(entity);
    }

    @GetMapping("/{id}")
    public Maintenance getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Maintenance update(@RequestBody Maintenance entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Maintenance> findAll() {
        return service.findAll();
    }
}
