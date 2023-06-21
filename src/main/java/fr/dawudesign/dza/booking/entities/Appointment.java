package fr.dawudesign.dza.booking.entities;

import fr.dawudesign.dza.users.entities.User;
import fr.dawudesign.dza.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Appointment extends AbstractEntity {

    private Date startDate;
    private Date endDate;

    @OneToOne
    private TimeSlot timeSlot;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
