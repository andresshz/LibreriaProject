package dev.project.library.adminController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.library.dto.ReservaDTO;
import dev.project.library.dto.ReservasDto;
import dev.project.library.entities.ReservasEntity;
import dev.project.library.services.Reservas.ReservasService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @PostMapping("/crear")
    public ReservasEntity crearReservas(@RequestBody ReservasDto body) {

        return reservasService.create(body);
    }

    @GetMapping("/buscar/{id}")
    public ReservasEntity obtenerReserva(@PathVariable(required = true) int id) {
        return reservasService.findById(id);
    }
    
    
    @GetMapping("/buscar")
    public List<ReservasEntity> obtenerReservas() {

        return reservasService.findAll();
    }

    @PostMapping("/responderReserva")
    public ReservasEntity responderReserva(@RequestBody ReservaDTO body) {
        
        return reservasService.responderReservas(body);
    }
    
    
}
