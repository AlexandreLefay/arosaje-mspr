package fr.epsi.mspr.arosaje.entity.mapper;

import fr.epsi.mspr.arosaje.entity.Guardianship;
import fr.epsi.mspr.arosaje.entity.dto.guardianship.GuardianshipDTO;
import fr.epsi.mspr.arosaje.entity.dto.guardianship.GuardianshipSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GuardianshipMapper {

    /**
     * Convert a Guardianship to a GuardianshipDTO
     */
    @Mapping(source = "ownerUser.id", target = "ownerId")
    @Mapping(source = "guardianUser.id", target = "guardianId")
    @Mapping(source = "plant.id", target = "plantId")
    GuardianshipDTO guardianshipToGuardianshipDTO(Guardianship guardianship);

    /**
     * Convert a GuardianshipDTO to a Guardianship
     */
    Guardianship guardianshipDTOToGuardianship(GuardianshipDTO guardianshipDTO);

    /**
     * Overwrite a Guardianship with a GuardianshipSaveRequest
     */
    void updateGuardianshipFromGuardianshipSaveRequest(GuardianshipSaveRequest guardianshipSaveRequest, @MappingTarget Guardianship guardianship);


}

