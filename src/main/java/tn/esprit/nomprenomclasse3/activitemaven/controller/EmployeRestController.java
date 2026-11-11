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
import tn.esprit.nomprenomclasse3.activitemaven.entities.Employe;
import tn.esprit.nomprenomclasse3.activitemaven.services.IEmployeServices;
import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeRestController {
    private final IEmployeServices service;

    @PostMapping
    public Employe create(@RequestBody Employe entity) {
        return service.add(entity);
    }

    @GetMapping("/{id}")
    public Employe getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Employe update(@RequestBody Employe entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Employe> findAll() {
        return service.findAll();
    }
}
