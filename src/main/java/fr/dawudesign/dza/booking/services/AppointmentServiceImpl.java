package fr.dawudesign.dza.booking.services;

import fr.dawudesign.dza.booking.dtos.AppointmentDTO;
import fr.dawudesign.dza.booking.entities.Appointment;
import fr.dawudesign.dza.booking.repositories.AppointmentRepository;
import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository repository;
    @Override
    public Iterable<AppointmentDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(AppointmentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findById(Long id) {
        return repository.findById(id)
                .map(AppointmentDTO::fromEntity)
                .orElseThrow(() -> new ParametrizeMessageException(
                HttpStatus.NOT_FOUND,
                "appointment.entity.not.found",
                "Appointment with id %s not found",
                id
        ));
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        Appointment appointment = AppointmentDTO.toEntity(appointmentDTO);
        return AppointmentDTO.fromEntity(repository.save(appointment));
    }

    @Override
    public AppointmentDTO update(Long id, AppointmentDTO appointmentDTO) {
        if(repository.existsById(id)){
            Appointment appointment = AppointmentDTO.toEntity(appointmentDTO);
            return AppointmentDTO.fromEntity(repository.save(appointment));
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "appointment.entity.not.found",
                    "Appointment with id %s not found",
                    id
            );
        }
    }

    @Override
    public void deleteById(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "appointment.entity.not.found",
                    "Appointment with id %s not found",
                    id
            );
        }
    }
}
