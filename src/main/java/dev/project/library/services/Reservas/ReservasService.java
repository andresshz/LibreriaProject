package dev.project.library.services.Reservas;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.library.Methods.Methods;
import dev.project.library.dto.ReservaDTO;
import dev.project.library.dto.ReservasDto;
import dev.project.library.entities.LibroEntity;
import dev.project.library.entities.ReservasEntity;
import dev.project.library.entities.UsuariosEntity;
import dev.project.library.repository.ReservasRepository;

@Service
public class ReservasService implements Methods<ReservasEntity, ReservasDto> {

    @Autowired
    private ReservasRepository reservasR;

    @Override
    public ReservasEntity create(ReservasDto dto) {

        ReservasEntity reservas = new ReservasEntity();

        LibroEntity libro = new LibroEntity();
        libro.setId(dto.getId_libro());

        UsuariosEntity usuario = new UsuariosEntity();
        usuario.setId(dto.getId_usuario());

        reservas.setUsuario(usuario);
        reservas.setLibro(libro);
        reservas.setStatus(dto.getStatus());
        reservas.setFechareserva(Timestamp.valueOf(dto.getFechareserva()));
        reservas.setFecharetorno(Timestamp.valueOf(dto.getFecharetorno()));

        try {

            return reservasR.save(reservas);

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<ReservasEntity> findAll() {

        try {
            return reservasR.findAll();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public ReservasEntity findById(int id) {

        try {
            return reservasR.findById(id).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    // Metodos solo del service Reservas.

    /*
     * STATUS:
     * 1 - PENDIENTE DE RESPONDER
     * 2- RECHZAR
     * 3- ACEPTADA
     */

    public ReservasEntity responderReservas(ReservaDTO reservaLibro) {

        ReservasEntity reserva = reservasR.findById(reservaLibro.getIdReserva()).orElse(null);

        if (reserva != null) {
            reserva.setStatus(reservaLibro.getStatus());
            reserva.setFecharetorno(Timestamp.valueOf(reservaLibro.getFecharetorno()));

            try {
                reservasR.save(reserva);
            } catch (Exception e) {
                return null;
            }

        }

        return reserva;

    }
}
