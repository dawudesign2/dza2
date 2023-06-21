package fr.dawudesign.dza.booking.dtos;

import fr.dawudesign.dza.booking.entities.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AppointmentDTO {

    private Long id;
    private Date startDate;
    private Date endDate;
    private Long userId;


    public static AppointmentDTO fromEntity(Appointment appointment) {
        return AppointmentDTO.builder()
                .id(appointment.getId())
                .startDate(appointment.getStartDate())
                .endDate(appointment.getEndDate())
                .userId(appointment.getUser() != null ? appointment.getUser().getId() : null)
                .build();
    }

    public static Appointment toEntity(AppointmentDTO appointmentDTO) {
        return Appointment.builder()
                .id(appointmentDTO.getId())
                .startDate(appointmentDTO.getStartDate())
                .endDate(appointmentDTO.getEndDate())
                .build();
    }
}
