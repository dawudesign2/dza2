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
public class Profile extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
