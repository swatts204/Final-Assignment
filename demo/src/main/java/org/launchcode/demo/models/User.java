package org.launchcode.demo.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private String role;

    @NotNull
    private String pwHash;




    public User(String username, String password, String role) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.role = role;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
