package com.example.demo.domain.appuser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author anton
 * @since 10/28/2022, Fri
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @Size(min = 3, max = 16)
    @NotNull
    @Column(unique = true)
    private String username;
    @Size(min = 4, max = 128)
    @NotNull
    private String password;
}
