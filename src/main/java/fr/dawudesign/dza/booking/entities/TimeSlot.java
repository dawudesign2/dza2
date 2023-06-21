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

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class TimeSlot extends AbstractEntity {

    private String startTime;
    private String endTime;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

}
