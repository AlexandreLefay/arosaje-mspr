package fr.epsi.mspr.arosaje.entity.mapper;

import fr.epsi.mspr.arosaje.entity.TicketComment;
import fr.epsi.mspr.arosaje.entity.dto.ticket.TicketCommentCreationDTO;
import fr.epsi.mspr.arosaje.entity.dto.ticket.TicketCommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketCommentMapper {
    TicketCommentMapper INSTANCE = Mappers.getMapper(TicketCommentMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "ticket.id", target = "ticketId")
    TicketCommentDTO ticketCommentToTicketCommentDTO(TicketComment comment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ticket", ignore = true)
    @Mapping(target = "user", ignore = true)
    TicketComment ticketCommentCreationDTOToTicketComment(TicketCommentCreationDTO commentDTO);
}