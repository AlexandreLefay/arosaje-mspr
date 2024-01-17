package fr.epsi.mspr.arosaje.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .requestMatchers("swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}


//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    // Bean pour configurer les règles de sécurité
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http// Définir les autorisations pour les URL
//                .authorizeRequests(authorize -> authorize
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // Seuls les utilisateurs avec le rôle ADMIN peuvent accéder aux chemins /admin/**
//                        .requestMatchers("api/users/**").hasAnyRole("USER", "ADMIN") // Les utilisateurs avec les rôles USER ou ADMIN peuvent accéder aux chemins /user/**
//                        .requestMatchers("/", "/home", "/register").permitAll() // Tout le monde peut accéder à ces chemins
//                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll()
//                        .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
//                );
//
//        return http.build();
//    }
//
//    // Bean pour le PasswordEncoder qui utilise BCrypt pour le hashage des mots de passe
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}