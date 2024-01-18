//package fr.epsi.mspr.arosaje.service;
//
//import fr.epsi.mspr.arosaje.config.JwtTokenProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Service
//public class LoginService {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider; // Un service pour générer des JWT
//
//    public String authenticateAndGetToken(String username, String password) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password));
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//            return jwtTokenProvider.createToken(userDetails.getUsername());
//        } catch (AuthenticationException e) {
//            throw new RuntimeException("Invalid username/password supplied");
//        }
//    }
//}
