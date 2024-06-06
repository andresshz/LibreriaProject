package dev.project.library.adminController;

import org.springframework.web.bind.annotation.RestController;

import dev.project.library.dto.LibroDto;
import dev.project.library.entities.LibroEntity;
import dev.project.library.services.Libros.LibroServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private LibroServices LibroServices;

    @PostMapping("/crear")
    public LibroEntity crearLibro(@RequestBody LibroDto body) {
        
        return LibroServices.create(body);
        
    }

    @GetMapping("/buscar")
    public List<LibroEntity> buscarLibros() {

        return LibroServices.findAll();

    }

    @GetMapping("/buscar/libro/{id}")
    public LibroEntity buscarLibro(@PathVariable(required = true) int id) {

        return LibroServices.findById(id);

    }
    

}
