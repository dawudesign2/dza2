package fr.dawudesign.dza.business.dtos;

import fr.dawudesign.dza.business.entities.Benefit;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BenefitDTO {
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    private String image;
    private String description;
    private Double price;
    @Positive
    private Integer duration;
    private Long businessId;
    private Long categoryId;


    public static BenefitDTO fromEntity(Benefit benefit) {
        return BenefitDTO.builder()
                .id(benefit.getId())
                .name(benefit.getName())
                .image(benefit.getImage())
                .description(benefit.getDescription())
                .price(benefit.getPrice())
                .duration(benefit.getDuration())
                .businessId(benefit.getBusiness() != null ? benefit.getBusiness().getId() : null)
                .categoryId(benefit.getCategory() != null ? benefit.getCategory().getId() : null)
                .build();
    }

    public static Benefit toEntity(BenefitDTO benefitDTO) {
        return Benefit.builder()
                .id(benefitDTO.getId())
                .name(benefitDTO.getName())
                .image(benefitDTO.getImage())
                .description(benefitDTO.getDescription())
                .price(benefitDTO.getPrice())
                .duration(benefitDTO.getDuration())
                .build();
    }
}
