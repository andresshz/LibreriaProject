package dev.project.library.services.Usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.project.library.Methods.Methods;
import dev.project.library.dto.UsuarioDTO;
import dev.project.library.entities.UsuariosEntity;
import dev.project.library.repository.UsuarioRepository;
import dev.project.library.response.ResponseClass;

@Service
public class UserService implements Methods<UsuariosEntity, UsuarioDTO> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarExistente(String username){

        if(usuarioRepository.findByUsername(username) != null){
            return true; // El usuario existe.
        }

        return false;
    }

    //Metodo personalizado.
    public ResponseClass crearUsuario(UsuarioDTO dto) {
        
        ResponseClass response = new ResponseClass();
        UsuariosEntity usuario = new UsuariosEntity();

        if(validarExistente(dto.getUsername())){
            response.setMensaje("Usuario Existente.");
            response.setObject(null);
            return response;
        };

        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        usuario.setRole(dto.getRole());
        
        try {
           UsuariosEntity userCreado = usuarioRepository.save(usuario);

            response.setMensaje("Usuario creado correctamente.");
            response.setObject(userCreado);

            return response;

        } catch (Exception e) {
            response.setMensaje("Error: " + e.getMessage());
            response.setObject(null);
            return response;
        }
        

    }

    @Override
    public List<UsuariosEntity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public UsuariosEntity findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public UsuariosEntity create(UsuarioDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

}
