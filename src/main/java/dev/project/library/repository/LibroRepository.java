package dev.project.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.project.library.entities.LibroEntity;

@Repository()
public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {

}
