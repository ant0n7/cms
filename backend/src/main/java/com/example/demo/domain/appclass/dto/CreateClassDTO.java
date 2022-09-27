package com.example.demo.domain.appclass.dto;

import com.example.demo.domain.appuser.User;
import com.example.demo.domain.appuser.dto.UsernameDTO;
import com.example.demo.domain.subjects.Subject;
import com.example.demo.domain.subjects.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassDTO {

    @Size(min =3, max = 16) @NotNull
    private String classname;

    private List<String> members;

    private List<String> subjects;

}
