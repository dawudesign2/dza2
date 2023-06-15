package fr.dawudesign.dza.users.services;

import fr.dawudesign.dza.users.dtos.ProfileDTO;
import fr.dawudesign.dza.users.entities.Profile;
import fr.dawudesign.dza.users.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository repository;
    @Override
    public Iterable<ProfileDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ProfileDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileDTO findById(Long id) {
        return repository.findById(id)
                .map(ProfileDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @Override
    public ProfileDTO save(ProfileDTO profileDTO) {
        Profile profile = ProfileDTO.toEntity(profileDTO);
        return ProfileDTO.fromEntity(repository.save(profile));
    }

    @Override
    public ProfileDTO update(Long id, ProfileDTO profileDTO) {
        if(repository.existsById(id)){
            Profile profile = ProfileDTO.toEntity(profileDTO);
            return ProfileDTO.fromEntity(repository.save(profile));
        } else {
            throw new RuntimeException("Profile not found");
        }
    }

    @Override
    public void deleteById(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Profile not found");
        }
    }
}
