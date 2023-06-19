package fr.dawudesign.dza.business.services;

import fr.dawudesign.dza.business.dtos.BenefitDTO;
import fr.dawudesign.dza.business.entities.Benefit;
import fr.dawudesign.dza.business.repositories.BenefitRepository;
import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {
    private final BenefitRepository repository;
    @Override
    public Iterable<BenefitDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(BenefitDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BenefitDTO findById(Long id) {
        return repository.findById(id)
                .map(BenefitDTO::fromEntity)
                .orElseThrow(() -> new ParametrizeMessageException(
                        HttpStatus.NOT_FOUND,
                        "benefit.entity.not.found",
                        "Benefit with id %s not found",
                        id
                ));
    }

    @Override
    public BenefitDTO save(BenefitDTO benefitDTO) {
        Benefit benefit = BenefitDTO.toEntity(benefitDTO);
        return BenefitDTO.fromEntity(repository.save(benefit));
    }

    @Override
    public BenefitDTO update(Long id, BenefitDTO benefitDTO) {
        if(repository.existsById(id)){
            Benefit benefit = BenefitDTO.toEntity(benefitDTO);
            return BenefitDTO.fromEntity(repository.save(benefit));
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "benefit.entity.not.found",
                    "Benefit with id %s not found",
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
                    "benefit.entity.not.found",
                    "Benefit with id %s not found",
                    id
            );
        }
    }
}
