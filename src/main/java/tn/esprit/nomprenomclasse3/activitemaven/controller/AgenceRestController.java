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
import tn.esprit.nomprenomclasse3.activitemaven.entities.Agence;
import tn.esprit.nomprenomclasse3.activitemaven.services.IAgenceServices;
import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceRestController {
    private final IAgenceServices service;

    @PostMapping
    public Agence create(@RequestBody Agence entity) {
        return service.add(entity);
    }

    @GetMapping("/{id}")
    public Agence getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    public Agence update(@RequestBody Agence entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Agence> findAll() {
        return service.findAll();
    }
}
