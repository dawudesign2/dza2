package fr.dawudesign.dza.business.controllers;

import fr.dawudesign.dza.business.dtos.CategoryDTO;
import fr.dawudesign.dza.business.services.CategoryService;
import fr.dawudesign.dza.utils.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
@Tag(name = "Categories")
public class CategoryController implements AbstractController<CategoryDTO> {
    private final CategoryService service;
    @Override
    public ResponseEntity<Iterable<CategoryDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<CategoryDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<CategoryDTO> save(CategoryDTO categoryDTO) {
        return ResponseEntity.ok(service.save(categoryDTO));
    }

    @Override
    public ResponseEntity<CategoryDTO> updateById(Long id, CategoryDTO categoryDTO) {
        return ResponseEntity.ok(service.update(id, categoryDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
