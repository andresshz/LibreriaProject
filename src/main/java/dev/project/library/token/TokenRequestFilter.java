package dev.project.library.token;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenRequestFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ") && !header.substring(7).isBlank()) {

            String token = header.substring(7);
            if (!validarToken(token)) {
                System.out.println("error");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

        }

        filterChain.doFilter(request, response);

    }

    public boolean validarToken(String accessToken) {

        JwtParser jwtParser = Jwts.parser()
                .verifyWith(TokenService.key) // Verifica el token con la llave secreta.
                .build();
        try {

            // jwtParser.parse(accessToken).getPayload().toString();

            jwtParser.parse(accessToken);

            Gson gson = new Gson();


            // Obtengo el payload
           JsonObject claims = gson.fromJson(jwtParser.parse(accessToken).getPayload().toString(), JsonObject.class);

           System.out.println(claims);
            boolean expired = claims.get("user").getAsJsonObject().get("credentialsNonExpired").getAsBoolean();

            if(expired){
                System.out.println("token vigente");
            }

           // System.out.println("El token");
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
            return false;

        }

    }

}
