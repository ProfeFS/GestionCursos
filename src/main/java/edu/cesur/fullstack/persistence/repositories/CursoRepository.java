package edu.cesur.fullstack.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cesur.fullstack.persistence.entities.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long>{

}
