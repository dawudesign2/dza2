package fr.dawudesign.dza.business.entities;

import fr.dawudesign.dza.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Category extends AbstractEntity {

    private String name;

    @OneToOne
    private Business business;
}
