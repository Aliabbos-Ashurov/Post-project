package com.abbos.postproject.mapper;

import com.abbos.postproject.config.CustomUserDetails;
import com.abbos.postproject.dto.request.UserCreateDTO;
import com.abbos.postproject.dto.request.UserUpdateDTO;
import com.abbos.postproject.dto.response.UserResponseDTO;
import com.abbos.postproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:01
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper
        extends GenericMapper<User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    CustomUserDetails toCustomUserDetails(User user);
}
