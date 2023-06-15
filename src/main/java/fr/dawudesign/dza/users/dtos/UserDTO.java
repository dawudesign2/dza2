package fr.dawudesign.dza.users.dtos;

import fr.dawudesign.dza.users.entities.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private Long roleId;
    private Long profileId;

    public static UserDTO fromEntity(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .roleId(user.getRole().getId())
                .profileId(user.getProfile() != null ? user.getProfile().getId() : null)
                .build();
    }

    public static User toEntity(UserDTO user) {
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.getEnabled())
                .build();
    }
}
