package com.ahmedhathout.skllstask.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;

@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "user_") // user is reserved in postgres
@JsonIgnoreProperties("password")
public class User implements UserDetails {     // By Convention, UserDetails Implementation should be a different class but I do not think that there is a need for that now at least.

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @ToString.Exclude
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    @Override
    public String getUsername() {
        return this.email;
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
    public boolean isEnabled() {
        return true;
    }
}
