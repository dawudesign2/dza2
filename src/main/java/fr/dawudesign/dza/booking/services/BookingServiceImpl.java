package fr.dawudesign.dza.booking.services;

import fr.dawudesign.dza.booking.dtos.BookingDTO;
import fr.dawudesign.dza.booking.entities.Booking;
import fr.dawudesign.dza.booking.repositories.BookingRepository;
import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;

    @Override
    public Iterable<BookingDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(BookingDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO findById(Long id) {
        return repository.findById(id)
                .map(BookingDTO::fromEntity)
                .orElseThrow(() ->  new ParametrizeMessageException(
                        HttpStatus.NOT_FOUND,
                        "booking.entity.not_found",
                        "Booking with id %s not found",
                        id
                ));
    }

    @Override
    public BookingDTO save(BookingDTO bookingDTO) {
        Booking booking = BookingDTO.toEntity(bookingDTO);
        return BookingDTO.fromEntity(repository.save(booking));
    }

    @Override
    public BookingDTO update(Long id, BookingDTO bookingDTO) {
        if (repository.existsById(id)) {
            Booking booking = BookingDTO.toEntity(bookingDTO);
            booking.setId(id);
            return BookingDTO.fromEntity(repository.save(booking));
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "booking.entity.not_found",
                    "Booking with id %s not found",
                    id
            );
        }
    }

    public BookingDTO patch (Long id, BookingDTO bookingDTO) {
        if (repository.existsById(id)) {
            Booking booking = BookingDTO.toEntity(bookingDTO);
            booking.setIsConfirmed(bookingDTO.getIsConfirmed());
            return BookingDTO.fromEntity(repository.save(booking));
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "booking.entity.not_found",
                    "Booking with id %s not found",
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
                    "booking.entity.not_found",
                    "Booking with id %s not found",
                    id
            );
        }
    }
}
