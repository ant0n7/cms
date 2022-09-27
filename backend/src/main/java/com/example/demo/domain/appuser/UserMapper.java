package com.example.demo.domain.appuser;

import com.example.demo.domain.appuser.dto.CreateUserDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUserDTOToUser(CreateUserDTO userDTO);
}
