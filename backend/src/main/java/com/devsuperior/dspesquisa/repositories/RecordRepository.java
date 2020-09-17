package com.devsuperior.dspesquisa.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
	@Query("Select obj from Record obj where "
			+ "(coalesce(:min,null) IS NULL OR obj.momentoRecord>= :min)"
			+ " AND "
			+ "(coalesce(:max,null) IS NULL OR obj.momentoRecord<= :max)")
	Page<Record> findByMomentos(Instant min, Instant max, Pageable page);
}
