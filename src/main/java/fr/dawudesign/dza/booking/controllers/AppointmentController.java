package fr.dawudesign.dza.booking.controllers;

import fr.dawudesign.dza.booking.dtos.AppointmentDTO;
import fr.dawudesign.dza.booking.services.AppointmentService;
import fr.dawudesign.dza.utils.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
@Tag(name = "Appointment")
public class AppointmentController implements AbstractController<AppointmentDTO> {
    private final AppointmentService service;
    @Override
    public ResponseEntity<Iterable<AppointmentDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<AppointmentDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<AppointmentDTO> save(AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(service.save(appointmentDTO));
    }

    @Override
    public ResponseEntity<AppointmentDTO> updateById(Long id, AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(service.update(id, appointmentDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
