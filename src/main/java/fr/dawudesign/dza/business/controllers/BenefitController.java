package fr.dawudesign.dza.business.controllers;

import fr.dawudesign.dza.business.dtos.BenefitDTO;
import fr.dawudesign.dza.business.services.BenefitService;
import fr.dawudesign.dza.utils.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/benefits")
@Tag(name = "Benefits")
public class BenefitController implements AbstractController<BenefitDTO> {

    private final BenefitService service;
    @Override
    public ResponseEntity<Iterable<BenefitDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<BenefitDTO> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<BenefitDTO> save(BenefitDTO benefitDTO) {
        return null;
    }

    @Override
    public ResponseEntity<BenefitDTO> updateById(Long id, BenefitDTO benefitDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return null;
    }
}
