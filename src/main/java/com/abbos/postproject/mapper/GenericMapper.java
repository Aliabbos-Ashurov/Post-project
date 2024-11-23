package com.abbos.postproject.mapper;

import com.abbos.postproject.dto.request.Request;
import com.abbos.postproject.dto.response.Response;
import com.abbos.postproject.entity.Auditable;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:01
 **/
public interface GenericMapper<
        E extends Auditable,
        R extends Response,
        CR extends Request,
        UD extends Request
        > extends CustomMapper {

    E toEntity(R response);

    R toDTO(E entiy);

    E fromCreate(CR create);

    E fromUpdate(UD update);
}
