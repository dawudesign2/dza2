package fr.dawudesign.dza.users.controllers;

import fr.dawudesign.dza.users.entities.Role;
import fr.dawudesign.dza.users.services.RoleService;
import fr.dawudesign.dza.utils.AbstractController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController implements AbstractController<Role> {

    private final RoleService service;
    @Override
    public ResponseEntity<Iterable<Role>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<Role> getById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @Override
    public ResponseEntity<Role> save(Role role) {
        return ResponseEntity.ok(service.save(role));
    }
    @Override
    public ResponseEntity<Role> updateById(Long id, Role role) {
        return ResponseEntity.ok(service.update(id, role));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
