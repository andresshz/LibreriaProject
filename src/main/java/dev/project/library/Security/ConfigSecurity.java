package dev.project.library.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import dev.project.library.services.Usuarios.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfigSecurity {

    // # El que se encarga de recibir la peticion.

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    
        return authenticationConfiguration.getAuthenticationManager();
    }

    // # El que se encarga de ir a buscar el usuario a la base.

    @Bean
    public AuthenticationProvider authenticationProvider(CustomUserDetailsService userDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    // # Codifica la password.

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // # El filtro de seguridad para las rutas

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.POST, "/crear-usuario").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/login").permitAll();
                    http.requestMatchers(HttpMethod.GET, "/actuator/prometheus").permitAll();

                    http.requestMatchers("/libros/**").hasAnyRole("admin");
                    http.requestMatchers(HttpMethod.GET, "/reservas-buscar").hasRole("admin"); // Endpoint para pruebas de acceso.

                    http.anyRequest().authenticated();
                })
                .build();
    }

}
