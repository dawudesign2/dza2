package fr.dawudesign.dza.booking.dtos;

import fr.dawudesign.dza.booking.entities.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TimeSlotDTO {

    private Long id;
    private String startTime;
    private String endTime;
    private Long appointmentId;

    public static TimeSlotDTO fromEntity(TimeSlot timeSlot) {
        return TimeSlotDTO.builder()
                .id(timeSlot.getId())
                .startTime(timeSlot.getStartTime())
                .endTime(timeSlot.getEndTime())
                .appointmentId(timeSlot.getAppointment() != null ? timeSlot.getAppointment().getId() : null)
                .build();
    }
    public static TimeSlot toEntity(TimeSlotDTO timeSlotDTO) {
        return TimeSlot.builder()
                .id(timeSlotDTO.getId())
                .startTime(timeSlotDTO.getStartTime())
                .endTime(timeSlotDTO.getEndTime())
                .build();
    }
}
