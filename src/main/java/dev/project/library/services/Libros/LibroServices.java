package dev.project.library.services.Libros;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.library.Methods.Methods;
import dev.project.library.dto.LibroDto;
import dev.project.library.entities.LibroEntity;
import dev.project.library.repository.LibroRepository;

@Service
public class LibroServices implements Methods<LibroEntity, LibroDto> {

    @Autowired
    private LibroRepository libro;

    @Override
    public LibroEntity create(LibroDto dto) {

        LibroEntity entidad = new LibroEntity();
        entidad.setNombreLibro(dto.getNombreLibro());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setFechaIngreso(Timestamp.valueOf(dto.getFechaIngreso()));

        try {
            libro.save(entidad);
            return entidad;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<LibroEntity> findAll() {
        try {
            return libro.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public LibroEntity findById(int id) {
        try {
            return libro.findById(id).orElseThrow(); // Devuelve error si no lo encuentra.
        } catch (Exception e) {
            return null;
        }
    }

}
