package org.launchcode.demo.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 5, max = 20, message = "Invalid Username. Must be between 5 and 20 characters.")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 20, message = "Invalid password. Must be between 5 and 20 characters.")
    private String password;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
