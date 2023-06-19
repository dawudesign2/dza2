package fr.dawudesign.dza.users.dtos;

import fr.dawudesign.dza.users.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String username;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8)
    private String password;
    private Boolean enabled;
    private Long roleId;
    private Long profileId;
    private Long businessId;

    public static UserDTO fromEntity(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .roleId(user.getRole().getId())
                .profileId(user.getProfile() != null ? user.getProfile().getId() : null)
                .businessId(user.getBusiness() != null ? user.getBusiness().getId() : null)
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
