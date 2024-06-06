package dev.project.library.services.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import dev.project.library.entities.UsuariosEntity;
import dev.project.library.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        UsuariosEntity usuario = repository.findByUsername(username);

        if(usuario == null){
            System.out.println("No se encontro");
            return null;
        }

        System.out.println(usuario.getUsername());
        System.out.println(usuario.getPassword());


        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        //roles.add(new SimpleGrantedAuthority("BASICO"));
        roles.add(new SimpleGrantedAuthority("ROLE_"+usuario.getRole())); // Se le asigna el role creado en la base de datos.


        System.out.println(roles);
        
		return new User(usuario.getUsername(), usuario.getPassword(), roles);

	}




}
