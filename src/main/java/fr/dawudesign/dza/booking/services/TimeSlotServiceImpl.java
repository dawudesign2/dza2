package fr.dawudesign.dza.booking.services;

import fr.dawudesign.dza.booking.dtos.TimeSlotDTO;
import fr.dawudesign.dza.booking.entities.TimeSlot;
import fr.dawudesign.dza.booking.repositories.TimeSlotRepository;
import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TimeSlotServiceImpl implements TimeSlotService{

    private final TimeSlotRepository repository;
    @Override
    public Iterable<TimeSlotDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(TimeSlotDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TimeSlotDTO findById(Long id) {

        return repository.findById(id)
                .map(TimeSlotDTO::fromEntity)
                .orElseThrow(() -> new ParametrizeMessageException(
                        HttpStatus.NOT_FOUND,
                        "timeslot.entity.not.found",
                        "TimeSlot with id %s not found",
                        id
                ));
    }

    @Override
    public TimeSlotDTO save(TimeSlotDTO timeSlotDTO) {
        TimeSlot timeSlot = TimeSlotDTO.toEntity(timeSlotDTO);
        return TimeSlotDTO.fromEntity(repository.save(timeSlot));
    }

    @Override
    public TimeSlotDTO update(Long id, TimeSlotDTO timeSlotDTO) {
        if (repository.existsById(id)) {
            TimeSlot timeSlot = TimeSlotDTO.toEntity(timeSlotDTO);
            return TimeSlotDTO.fromEntity(repository.save(timeSlot));
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "timeslot.entity.not.found",
                    "TimeSlot with id %s not found",
                    id
            );
        }
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "timeslot.entity.not.found",
                    "TimeSlot with id %s not found",
                    id
            );
        }
    }
}
