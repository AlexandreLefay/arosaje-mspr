package fr.epsi.mspr.arosaje.entity.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketCommentDTO {

    private Long id;
    private String comment;
    private LocalDateTime createdAt;
    private Long ticketId;
    private Long userId;
}