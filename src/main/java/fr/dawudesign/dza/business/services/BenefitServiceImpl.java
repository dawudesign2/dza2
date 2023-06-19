package fr.dawudesign.dza.business.services;

import fr.dawudesign.dza.business.dtos.BenefitDTO;
import fr.dawudesign.dza.business.repositories.BenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {
    private final BenefitRepository repository;
    @Override
    public Iterable<BenefitDTO> findAll() {
        return null;
    }

    @Override
    public BenefitDTO findById(Long id) {
        return null;
    }

    @Override
    public BenefitDTO save(BenefitDTO benefitDTO) {
        return null;
    }

    @Override
    public BenefitDTO update(Long id, BenefitDTO benefitDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
