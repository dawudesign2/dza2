package fr.dawudesign.dza.users.controllers;

import fr.dawudesign.dza.users.dtos.ProfileDTO;
import fr.dawudesign.dza.users.dtos.UserDTO;
import fr.dawudesign.dza.users.services.UserService;
import fr.dawudesign.dza.utils.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController implements AbstractController<UserDTO> {
    private final UserService service;
    @Override
    public ResponseEntity<Iterable<UserDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @Override
    public ResponseEntity<UserDTO> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @Override
    public ResponseEntity<UserDTO> save(UserDTO userDTO) {
        return ResponseEntity.ok(service.save(userDTO));
    }
    @Override
    public ResponseEntity<UserDTO> updateById(Long id, UserDTO userDTO) {
        return ResponseEntity.ok(service.update(id, userDTO));
    }
    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
