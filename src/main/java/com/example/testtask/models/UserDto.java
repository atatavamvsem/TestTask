package com.example.testtask.models;

import javax.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty
    private String username;

    private String password;
}
