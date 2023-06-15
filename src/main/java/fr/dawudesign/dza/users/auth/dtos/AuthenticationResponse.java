package fr.dawudesign.dza.users.auth.dtos;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
}
