package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.dto.login.LoginRequest;
import fr.epsi.mspr.arosaje.entity.dto.login.LoginResponse;
import fr.epsi.mspr.arosaje.security.CustomUserDetails;
import fr.epsi.mspr.arosaje.security.JwtUtil;
import fr.epsi.mspr.arosaje.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/login")
    public LoginResponse createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
        // Authentifier l'utilisateur
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        // Charger les détails de l'utilisateur après authentification
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        // Vérifier si userDetails est une instance de CustomUserDetails
        if (!(userDetails instanceof CustomUserDetails)) {
            throw new Exception("Les détails de l'utilisateur ne sont pas de type CustomUserDetails");
        }

        // Générer le JWT à partir des CustomUserDetails
        CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
        final String jwt = jwtTokenUtil.generateToken(customUserDetails);

        // Retourner la réponse avec le JWT
        return new LoginResponse(jwt);
    }
}
