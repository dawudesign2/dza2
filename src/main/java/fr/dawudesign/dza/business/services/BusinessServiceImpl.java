package fr.dawudesign.dza.business.services;

import fr.dawudesign.dza.business.dtos.BusinessDTO;
import fr.dawudesign.dza.business.entities.Business;
import fr.dawudesign.dza.business.repositories.BusinessRepository;
import fr.dawudesign.dza.exeptions.ObjectValidator;
import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    private final BusinessRepository repository;
    private final ObjectValidator<BusinessDTO> validator;
    @Override
    public Iterable<BusinessDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(BusinessDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BusinessDTO findById(Long id) {
        return repository.findById(id)
                .map(BusinessDTO::fromEntity)
                .orElseThrow(() -> new ParametrizeMessageException(
                        HttpStatus.NOT_FOUND,
                        "business.entity.not.found",
                        "Business with id %s not found",
                        id
                ));
    }

    @Override
    public BusinessDTO save(BusinessDTO businessDTO) {
        Business business = BusinessDTO.toEntity(businessDTO);
        business.setActive(true);
        return BusinessDTO.fromEntity(repository.save(business));
    }

    @Override
    public BusinessDTO update(Long id, BusinessDTO businessDTO) {
        if(repository.existsById(id)){
            Business business = BusinessDTO.toEntity(businessDTO);
            return BusinessDTO.fromEntity(repository.save(business));
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "business.entity.not.found",
                    "Business with id %s not found",
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
                    "business.entity.not.found",
                    "Business with id %s not found",
                    id
            );
        }
    }
}
