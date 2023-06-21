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
@Tag(name = "Benefit")
public class BenefitController implements AbstractController<BenefitDTO> {

    private final BenefitService service;
    @Override
    public ResponseEntity<Iterable<BenefitDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<BenefitDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<BenefitDTO> save(BenefitDTO benefitDTO) {
        return ResponseEntity.ok(service.save(benefitDTO));
    }

    @Override
    public ResponseEntity<BenefitDTO> updateById(Long id, BenefitDTO benefitDTO) {
        return ResponseEntity.ok(service.update(id, benefitDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
