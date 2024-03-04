package com.andyWork.challenge.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.andyWork.challenge.domain.service.PlatoService;
import com.andyWork.challenge.persistence.entity.Plato;

import java.util.List;

@RestController
// @RequestMapping("/api/platos")
public class PlatoController {
    
    @Autowired
    private final PlatoService platoService;
    
    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/{id}")
    public Plato getPlatoById(@PathVariable Integer id) {
        return platoService.getById(id);
    }

    @GetMapping("/platos")
    public List<Plato> getAllPlatos() {
        return platoService.getAll();
    }

    @PostMapping
    public void addPlato(@RequestBody Plato plato) {
        platoService.savePlato(plato);
    }

    @DeleteMapping("/{id}")
    public void deletePlato(@PathVariable Integer id) {
        platoService.deletePlato(id);
    }

}
