package fr.dawudesign.dza.users.auth.dtos;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
