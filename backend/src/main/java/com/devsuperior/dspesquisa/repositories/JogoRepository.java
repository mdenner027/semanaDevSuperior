package com.devsuperior.dspesquisa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{
	Jogo findByIdJogo(Long id);
	
	List<Jogo> findAllByOrderByTituloJogo();
}
