package fr.epsi.mspr.arosaje.entity.dto.user;

import fr.epsi.mspr.arosaje.entity.dto.adresse.AddressDTO;
import fr.epsi.mspr.arosaje.entity.dto.role.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private AddressDTO address;
    private float x;
    private float y;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<RoleDTO> roles;
}
