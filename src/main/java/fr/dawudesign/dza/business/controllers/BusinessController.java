package fr.dawudesign.dza.business.controllers;

import fr.dawudesign.dza.business.dtos.BusinessDTO;
import fr.dawudesign.dza.business.services.BusinessService;
import fr.dawudesign.dza.utils.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/business")
public class BusinessController implements AbstractController<BusinessDTO> {

    private final BusinessService service;

    @Override
    public ResponseEntity<Iterable<BusinessDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<BusinessDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<BusinessDTO> save(BusinessDTO businessDTO) {
        return ResponseEntity.ok(service.save(businessDTO));
    }

    @Override
    public ResponseEntity<BusinessDTO> updateById(Long id, BusinessDTO businessDTO) {
        return ResponseEntity.ok(service.update(id, businessDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
