package com.example.testtask.models;

import com.example.testtask.annotations.ValidPassword;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

public class UserDto {

    private long id;
    @Length(max = 16, message = "too long(more 16)")
    @Length(min = 3, message = "min 3 symbol")
    private String username;
    @NotBlank(message = "Empty")
    @Length(max = 16, message = "too long(more 16)")
    private String firstname;
    @NotBlank(message = "Empty")
    @Length(max = 16, message = "too long(more 16)")
    private String lastname;
    private boolean status;
    @ValidPassword
    private String password;
    private LocalDate created;
    private Set<Role> roles;

    public UserDto() {
    }

    public UserDto(String username, String firstName, String lastName, boolean status) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
