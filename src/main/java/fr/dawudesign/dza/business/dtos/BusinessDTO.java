package fr.dawudesign.dza.business.dtos;
import fr.dawudesign.dza.business.entities.Business;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BusinessDTO {

    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    private String description;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    @Pattern(regexp = "^(\\+33|0)[1-9](\\d{2}){4}$")
    private String phone;
    @Email
    private String email;
    private String website;
    private String logo;
    private String siret;
    private Boolean active;

    public static BusinessDTO fromEntity(Business business) {
        return BusinessDTO.builder()
                .id(business.getId())
                .name(business.getName())
                .description(business.getDescription())
                .address(business.getAddress())
                .city(business.getCity())
                .country(business.getCountry())
                .zipCode(business.getZipCode())
                .phone(business.getPhone())
                .email(business.getEmail())
                .website(business.getWebsite())
                .logo(business.getLogo())
                .siret(business.getSiret())
                .active(business.getActive())
                .build();
    }

    public static Business toEntity(BusinessDTO businessDTO) {
        return Business.builder()
                .id(businessDTO.getId())
                .name(businessDTO.getName())
                .description(businessDTO.getDescription())
                .address(businessDTO.getAddress())
                .city(businessDTO.getCity())
                .country(businessDTO.getCountry())
                .zipCode(businessDTO.getZipCode())
                .phone(businessDTO.getPhone())
                .email(businessDTO.getEmail())
                .website(businessDTO.getWebsite())
                .logo(businessDTO.getLogo())
                .siret(businessDTO.getSiret())
                .active(businessDTO.getActive())
                .build();
    }

}
