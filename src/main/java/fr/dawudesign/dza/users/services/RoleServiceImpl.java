package fr.dawudesign.dza.users.services;

import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import fr.dawudesign.dza.users.entities.Role;
import fr.dawudesign.dza.users.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    @Override
    public Iterable<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> role = repository.findById(id);
        return role.orElseThrow(() -> new ParametrizeMessageException(
                HttpStatus.NOT_FOUND,
                "Role.entity.not.found",
                "Profile with id %s not found",
                id
        ));
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Optional<Role> roleOptional = repository.findById(id);
        if (roleOptional.isPresent()) {
            Role roleFromDb = roleOptional.get();
            roleFromDb.setName(role.getName());
            return repository.save(roleFromDb);
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "Role.entity.not.found",
                    "Profile with id %s not found",
                    id
            );
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Role> role = repository.findById(id);
        if (role.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "Role.entity.not.found",
                    "Profile with id %s not found",
                    id
            );
        }
    }
}
