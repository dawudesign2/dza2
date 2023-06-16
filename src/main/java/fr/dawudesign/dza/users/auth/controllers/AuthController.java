package fr.dawudesign.dza.users.auth.controllers;

import fr.dawudesign.dza.users.auth.dtos.AuthenticationRequest;
import fr.dawudesign.dza.users.auth.dtos.AuthenticationResponse;
import fr.dawudesign.dza.users.auth.services.AuthService;
import fr.dawudesign.dza.users.dtos.UserDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody  UserDTO user
    ) {
        return ResponseEntity.ok(authService.register(user)) ;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
            ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
