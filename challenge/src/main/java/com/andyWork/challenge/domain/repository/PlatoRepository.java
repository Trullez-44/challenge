package com.andyWork.challenge.domain.repository;
import com.andyWork.challenge.persistence.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {

}