package com.abbos.postproject.mapper;

import com.abbos.postproject.dto.request.PostCreateDTO;
import com.abbos.postproject.dto.request.PostUpdateDTO;
import com.abbos.postproject.dto.response.PostResponseDTO;
import com.abbos.postproject.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:09
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper
        extends GenericMapper<Post, PostResponseDTO, PostCreateDTO, PostUpdateDTO> {
}
