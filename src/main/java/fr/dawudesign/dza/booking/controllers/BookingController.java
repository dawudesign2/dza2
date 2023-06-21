package fr.dawudesign.dza.booking.controllers;

import fr.dawudesign.dza.booking.dtos.BookingDTO;
import fr.dawudesign.dza.booking.services.BookingService;
import fr.dawudesign.dza.utils.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@Tag(name = "Booking")
@RequiredArgsConstructor
public class BookingController implements AbstractController<BookingDTO> {
    private final BookingService service;

    @Override
    public ResponseEntity<Iterable<BookingDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<BookingDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<BookingDTO> save(BookingDTO bookingDTO) {
        return ResponseEntity.ok(service.save(bookingDTO));
    }

    @Override
    public ResponseEntity<BookingDTO> updateById(Long id, BookingDTO bookingDTO) {
        return ResponseEntity.ok(service.update(id, bookingDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookingDTO> patchById(Long id, BookingDTO bookingDTO) {
        return ResponseEntity.ok(service.patch(id, bookingDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
