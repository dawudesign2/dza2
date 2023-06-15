package fr.dawudesign.dza.users.auth.services;

import fr.dawudesign.dza.users.auth.dtos.AuthenticationRequest;
import fr.dawudesign.dza.users.auth.dtos.AuthenticationResponse;
import fr.dawudesign.dza.users.dtos.UserDTO;

public interface AuthService {
    AuthenticationResponse register(UserDTO user);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
