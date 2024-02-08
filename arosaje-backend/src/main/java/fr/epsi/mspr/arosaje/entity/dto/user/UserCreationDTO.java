package fr.epsi.mspr.arosaje.entity.dto.user;

import fr.epsi.mspr.arosaje.entity.Photo;
import fr.epsi.mspr.arosaje.entity.dto.adresse.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDTO {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private AddressDTO address;
    private float x;
    private float y;
    private String password;
    private Set<String> roleNames;
    private Photo photoProfil;
}
