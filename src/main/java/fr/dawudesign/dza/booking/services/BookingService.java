package fr.dawudesign.dza.booking.services;

import fr.dawudesign.dza.booking.dtos.BookingDTO;
import fr.dawudesign.dza.utils.AbstractService;

public interface BookingService extends AbstractService<BookingDTO> {
    BookingDTO patch(Long id, BookingDTO bookingDTO);
}
