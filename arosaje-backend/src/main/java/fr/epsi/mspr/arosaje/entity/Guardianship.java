package fr.epsi.mspr.arosaje.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "guardianships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guardianship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private Plant plant;

    @ManyToOne
    @JoinColumn(name = "guardian_user_id", referencedColumnName = "id")
    private User guardianUser;

    @ManyToOne
    @JoinColumn(name = "owner_user_id", referencedColumnName = "id")
    private User ownerUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = true)
    private Status status;

    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
