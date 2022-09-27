package com.example.demo.domain.appuser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    @Size(min = 2, max = 25) @NotNull
    private String firstname;
    @Size(min = 2, max = 25) @NotNull
    private String lastname;
    @Size(min =3, max = 16) @NotNull
    private String username;
    @Email
    @NotNull
    private String email;
    @Size(min = 4, max = 128) @NotNull
    private String password;
}