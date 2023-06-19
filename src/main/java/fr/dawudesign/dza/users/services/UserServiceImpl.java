package fr.dawudesign.dza.users.services;

import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import fr.dawudesign.dza.users.dtos.UserDTO;
import fr.dawudesign.dza.users.entities.User;
import fr.dawudesign.dza.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public Iterable<UserDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return repository.findById(id)
                .map(UserDTO::fromEntity)
                .orElseThrow(() -> new ParametrizeMessageException(
                        HttpStatus.NOT_FOUND,
                        "user.entity.not.found",
                        "user with id %s not found",
                        id
                ));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = UserDTO.toEntity(userDTO);
        return UserDTO.fromEntity(repository.save(user));
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        if(repository.existsById(id)){
            User user = UserDTO.toEntity(userDTO);
            return UserDTO.fromEntity(repository.save(user));
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "user.entity.not.found",
                    "User with id %s not found",
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
                    "user.entity.not.found",
                    "User with id %s not found",
                    id
            );
        }
    }
}
