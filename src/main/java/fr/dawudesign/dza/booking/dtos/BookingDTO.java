package fr.dawudesign.dza.booking.dtos;

import fr.dawudesign.dza.booking.entities.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long collaboratorId;
    private Long BenefitId;
    private Boolean isConfirmed;

    public static BookingDTO fromEntity(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .userId(booking.getUser().getId())
                .collaboratorId(booking.getCollaboratorId())
                .isConfirmed(booking.getIsConfirmed())
                .build();
    }

    public static Booking toEntity(BookingDTO booking) {
        return Booking.builder()
                .id(booking.getId())
                .collaboratorId(booking.getCollaboratorId())
                .isConfirmed(booking.getIsConfirmed())
                .build();
    }
}
