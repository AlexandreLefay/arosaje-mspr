package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.dto.login.LoginRequest;
import fr.epsi.mspr.arosaje.entity.dto.login.LoginResponse;
import fr.epsi.mspr.arosaje.security.CustomUserDetails;
import fr.epsi.mspr.arosaje.security.JwtUtil;
import fr.epsi.mspr.arosaje.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RestController
@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        // Charger les détails de l'utilisateur après authentification
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        // Générer le JWT à partir des CustomUserDetails
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        // Récupérer les informations de l'utilisateur
        String username = userDetails.getUsername();
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        // Ajouter le token dans l'en-tête X-Authorization de la réponse
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Authorization", jwt);

        // Retourner la réponse avec les détails de l'utilisateur et le JWT dans l'en-tête
        return ResponseEntity.ok().headers(headers).body(new LoginResponse(username, roles.toString()));
    }
}
