package com.andyWork.challenge.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.andyWork.challenge.domain.service.PlatoService;
import com.andyWork.challenge.persistence.entity.Plato;

import java.util.List;

@RestController
 @RequestMapping("/api/platos")
@CrossOrigin("*")
public class PlatoController {
    
    @Autowired
    private final PlatoService platoService;
    
    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/get/{id}")
    public Plato getPlatoById(@PathVariable Integer id) {
        return platoService.getById(id);
    }

    @GetMapping()
    public List<Plato> getAllPlatos() {
        return platoService.getAll();
    }

    @PostMapping("/add")
    public void addPlato(@RequestBody Plato plato) {
        platoService.savePlato(plato);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlato(@PathVariable Integer id) {
        platoService.deletePlato(id);
    }

    @PutMapping("/update")
    public void updatePlato(@RequestBody Plato plato){
        platoService.updatePlato(plato);
    }
}
