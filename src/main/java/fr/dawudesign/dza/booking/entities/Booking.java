package fr.dawudesign.dza.booking.entities;

import fr.dawudesign.dza.business.entities.Benefit;
import fr.dawudesign.dza.users.entities.User;
import fr.dawudesign.dza.utils.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Booking extends AbstractEntity {

    private Long collaboratorId;

    @Column(columnDefinition = "boolean default false")
    private Boolean isConfirmed;

    @OneToOne
    @JoinColumn(name = "benefit_id")
    private Benefit benefit;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
