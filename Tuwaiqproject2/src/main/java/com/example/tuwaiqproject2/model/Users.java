package com.example.tuwaiqproject2.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Users {
    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "id must be 3 or more character long")
    private String id;
    @NotEmpty(message = "username is required")
    @Size(min = 3,message = "username must be 3 or more character long")
    private String username;
    @NotEmpty(message = "id is required")
    @Size(min = 3,message = "password must be 3 or more character long")
   // @Pattern (regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]){6,20}$",message = "password must be digit and character and more than 6 long")
    private String password;
    @NotEmpty (message = "email is required")
    @Email (message = "email is invalid !")
    private String email;
    @NotEmpty (message = "role is required")
    @Pattern(regexp = "Admin|Customer",message = "role must be Admin or customer ")
    private String role;
    @NotNull (message = "balance is required ")
    @Positive (message = "balance must be positive number")
    private Integer balance;
}
