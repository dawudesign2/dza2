package fr.dawudesign.dza.users.auth.controllers;

import fr.dawudesign.dza.users.auth.dtos.AuthenticationRequest;
import fr.dawudesign.dza.users.auth.dtos.AuthenticationResponse;
import fr.dawudesign.dza.users.auth.services.AuthService;
import fr.dawudesign.dza.users.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
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
