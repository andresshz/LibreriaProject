package dev.project.library.authController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.project.library.dto.LoginDTO;
import dev.project.library.dto.UsuarioDTO;
import dev.project.library.entities.UsuariosEntity;
import dev.project.library.response.ResponseClass;
import dev.project.library.services.Usuarios.UserService;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService usuService;

    @PostMapping("/login")
    public String login(@RequestBody(required = true) LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "ok";
        } catch (Exception e) {
            return "error" + e.getMessage();
        }

    }

    @PostMapping("/crear-usuario")
    public ResponseClass registro(@RequestBody(required = true) UsuarioDTO usuarioDTO) {
        return usuService.crearUsuario(usuarioDTO);
    }

    @GetMapping("/reservas-buscar")
    @PreAuthorize("hasRole('admin')")
    public String obtenerReservas() {
        return "RESERVAS";

    }

}
