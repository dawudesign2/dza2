package fr.dawudesign.dza.users.controllers;

import fr.dawudesign.dza.users.dtos.ProfileDTO;
import fr.dawudesign.dza.users.services.ProfileService;
import fr.dawudesign.dza.utils.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
@Tag(name = "Profile")
public class ProfileController implements AbstractController<ProfileDTO> {
    private final ProfileService service;
    @Override
    public ResponseEntity<Iterable<ProfileDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<ProfileDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<ProfileDTO> save(ProfileDTO profileDTO) {
        return ResponseEntity.ok(service.save(profileDTO));
    }
    @Override
    public ResponseEntity<ProfileDTO> updateById(Long id, ProfileDTO profileDTO) {
        return ResponseEntity.ok(service.update(id, profileDTO));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
