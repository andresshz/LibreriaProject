package dev.project.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.project.library.entities.ReservasEntity;

@Repository()
public interface ReservasRepository extends JpaRepository<ReservasEntity, Integer> {

}
