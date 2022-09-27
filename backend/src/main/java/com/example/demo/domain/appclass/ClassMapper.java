package com.example.demo.domain.appclass;

import com.example.demo.domain.appclass.dto.RestrictedClassInformationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    RestrictedClassInformationDTO classToRestrictedClassInformationDTO(Class appclass);
    Class restrictedClassInformationDTOToClass(RestrictedClassInformationDTO appclass);


}
