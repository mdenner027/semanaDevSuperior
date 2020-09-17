package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
