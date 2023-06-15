package fr.dawudesign.dza.users.entities;

import fr.dawudesign.dza.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Role extends AbstractEntity {

    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
