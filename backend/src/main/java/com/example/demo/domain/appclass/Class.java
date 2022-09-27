package com.example.demo.domain.appclass;

import com.example.demo.domain.appuser.User;
import com.example.demo.domain.subjects.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity(name = "tbl_class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(min =3, max = 16) @NotNull
    private String classname;

    @ManyToMany(cascade=CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "tbl_class_members",
            joinColumns = @JoinColumn(
                    name = "class_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "member_id", referencedColumnName = "id"))
    private List<User> members;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "tbl_class_subjects",
            joinColumns = @JoinColumn(
                    name = "class_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id", referencedColumnName = "id"))
    private List<Subject> subjects;

}
