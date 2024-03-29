package com.andyWork.challenge.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andyWork.challenge.domain.repository.PlatoRepository;
import com.andyWork.challenge.persistence.entity.Plato;


@Service
public class PlatoService {

    @Autowired
    private final PlatoRepository platoRepository;

    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public List<Plato> getAll() {
        return platoRepository.findAll();
    }

    public Plato getById(Integer id) {
        return platoRepository.findById(id).orElse(null);
    }

    public Plato savePlato(Plato plato) {

        return platoRepository.save(plato);
    }

    public void deletePlato(Integer id) {

        platoRepository.deleteById(id);
    }

    public void updatePlato(Plato plato) {
        Plato platoExist = platoRepository.findById(plato.getPlatoId()).orElse(null);
        if (platoExist != null) {
            platoExist.setNombre(plato.getNombre());
            platoExist.setDescripcion(plato.getDescripcion());
            platoExist.setPrecio(plato.getPrecio());
            platoRepository.save(platoExist);
        }
        else {
            throw new Error("El plato no existe sapa");
        }


    }
} 
