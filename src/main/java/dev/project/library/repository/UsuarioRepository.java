package dev.project.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.project.library.entities.UsuariosEntity;



@Repository()
public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Integer> {

    UsuariosEntity findByUsername(String username);

}
