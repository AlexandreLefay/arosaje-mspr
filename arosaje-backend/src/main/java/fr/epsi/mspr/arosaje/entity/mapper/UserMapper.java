package fr.epsi.mspr.arosaje.entity.mapper;

import fr.epsi.mspr.arosaje.entity.Address;
import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.entity.dto.adresse.AddressDTO;
import fr.epsi.mspr.arosaje.entity.dto.user.UserCreationDTO;
import fr.epsi.mspr.arosaje.entity.dto.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user The User entity to be converted.
     * @return The corresponding UserDTO.
     */
    @Mapping(target = "profilPictureBlob", source = "photoProfil.imageBlob")
    UserDTO userToUserDTO(User user);

    /**
     * Converts an Address entity to an AddressDTO.
     *
     * @param address The Address entity to be converted.
     * @return The corresponding AddressDTO.
     */
    AddressDTO addressToAddressDTO(Address address);

    /**
     * Converts an AddressDTO to an Address entity.
     *
     * @param addressDTO The AddressDTO to be converted.
     * @return The corresponding Address entity.
     */
    Address addressDTOToAddress(AddressDTO addressDTO);

    /**
     * Converts a UserCreationDTO to a User entity.
     *
     * @param userDTO The UserCreationDTO to be converted.
     * @return The corresponding User entity.
     */
    User userDTOToUser(UserCreationDTO userDTO);

    /**
     * Updates a User entity with the data provided in a UserCreationDTO.
     *
     * @param userCreationDTO The DTO containing the new user data.
     * @param user            The User entity to be updated.
     */
    void updateUserFromDto(UserCreationDTO userCreationDTO, @MappingTarget User user);
}

