package fr.dawudesign.dza.users.entities;

import fr.dawudesign.dza.booking.entities.Appointment;
import fr.dawudesign.dza.booking.entities.Booking;
import fr.dawudesign.dza.business.entities.Business;
import fr.dawudesign.dza.utils.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class User extends AbstractEntity implements UserDetails {

    @Column(nullable = false, unique = true )
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "boolean default false")
    private Boolean enabled;

    @OneToOne
    private Role role;

    @OneToOne
    private Profile profile;

    @OneToOne
    private Appointment appointment;

    @OneToOne
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority(role.getName())
        );
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {return enabled;}
}
