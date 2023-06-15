package fr.dawudesign.dza.users.auth.services;

import fr.dawudesign.dza.users.auth.dtos.AuthenticationRequest;
import fr.dawudesign.dza.users.auth.dtos.AuthenticationResponse;
import fr.dawudesign.dza.users.auth.utils.JwtUtils;
import fr.dawudesign.dza.users.dtos.UserDTO;
import fr.dawudesign.dza.users.entities.Role;
import fr.dawudesign.dza.users.entities.User;
import fr.dawudesign.dza.users.repositories.RoleRepository;
import fr.dawudesign.dza.users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;



@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final Map<String, Object> claims = new HashMap<>();

    @Override
    @Transactional
    public AuthenticationResponse register(UserDTO user) {
        User userRegister = UserDTO.toEntity(user);
        userRegister.setPassword(passwordEncoder.encode(user.getPassword()));
        String ROLE_NAME = "Customer";
        userRegister.setRole(findCreateOrRole(ROLE_NAME));
        var userSaved = userRepository.save(userRegister);
        claims.put("id", userSaved.getId());
        claims.put("username", userSaved.getUsername());
        String Token = JwtUtils.generateToken(userSaved, claims);
        return AuthenticationResponse.builder()
                .token(Token)
                .build();
    }

    private Role findCreateOrRole(String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElse(null);
        if(role == null){
            return roleRepository.save(
                    Role.builder()
                            .name(roleName)
                            .build()
            );
        }
        return role;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        String Token = JwtUtils.generateToken(user, claims);
        return AuthenticationResponse.builder()
                .token(Token)
                .build();
    }
}
