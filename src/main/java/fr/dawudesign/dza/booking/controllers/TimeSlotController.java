package fr.dawudesign.dza.booking.controllers;

import fr.dawudesign.dza.booking.dtos.TimeSlotDTO;
import fr.dawudesign.dza.booking.services.TimeSlotService;
import fr.dawudesign.dza.utils.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/timeslots")
@Tag(name = "TimeSlot")
public class TimeSlotController implements AbstractController<TimeSlotDTO> {

    private final TimeSlotService service;
    @Override
    public ResponseEntity<Iterable<TimeSlotDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<TimeSlotDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<TimeSlotDTO> save(TimeSlotDTO timeSlotDTO) {
        return ResponseEntity.ok(service.save(timeSlotDTO));
    }

    @Override
    public ResponseEntity<TimeSlotDTO> updateById(Long id, TimeSlotDTO timeSlotDTO) {
        return ResponseEntity.ok(service.update(id, timeSlotDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
