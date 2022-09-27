package com.example.demo.domain.appuser;


import com.example.demo.domain.role.Role;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;

@Entity(name="tbl_user")
//from lombok
@Getter@Setter
@NoArgsConstructor @AllArgsConstructor
@OnDelete(action = OnDeleteAction.CASCADE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Size(min = 2, max = 25) @NotNull
    private String firstname;
    @Size(min = 2, max = 25) @NotNull
    private String lastname;
    @Size(min =3, max = 16) @NotNull
    @Column(unique = true)
    private String username;
    @Email @NotNull
    @Column(unique = true)
    private String email;
    @Size(min = 4, max = 128) @NotNull
    private String password;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany()
    @JoinTable(
            name = "tbl_user_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

}
