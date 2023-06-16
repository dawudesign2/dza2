package fr.dawudesign.dza.business.entities;

import fr.dawudesign.dza.users.entities.User;
import fr.dawudesign.dza.utils.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Business extends AbstractEntity {

    @Column(unique = true)
    private String name;
    private String description;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private String phone;
    private String email;
    private String website;
    private String logo;
    @Column(unique = true)
    private String siret;
    @Column(columnDefinition = "boolean default false")
    private Boolean active;

    @OneToMany(mappedBy = "business")
    private Set<User> user;
}
