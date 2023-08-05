package com.genka.cleancommerce.infra.auth.adapters;

import com.genka.cleancommerce.domain.user.User;
import com.genka.cleancommerce.domain.user.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class UserAuthDetails implements UserDetails {
    private UUID id;
    private String email;
    private Role role;
    private String password;
    private String name;

    public UserAuthDetails() {
    }

    public UserAuthDetails(String email, String password, Role role, String username) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = username;
    }

    public UserAuthDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.name = user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
