package fr.dawudesign.dza.users.dtos;
import fr.dawudesign.dza.users.entities.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProfileDTO {
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Pattern(regexp = "^(\\+33|0)[1-9](\\d{2}){4}$")
    private String phone;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private Long userId;

    public static ProfileDTO fromEntity(Profile profile) {
        return ProfileDTO.builder()
                .id(profile.getId())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .address(profile.getAddress())
                .city(profile.getCity())
                .country(profile.getCountry())
                .zipCode(profile.getZipCode())
                .userId(profile.getUser().getId())
                .build();
    }

    public static Profile toEntity(ProfileDTO profile) {
        return Profile.builder()
                .id(profile.getId())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .address(profile.getAddress())
                .city(profile.getCity())
                .country(profile.getCountry())
                .zipCode(profile.getZipCode())
                .build();
    }
}
