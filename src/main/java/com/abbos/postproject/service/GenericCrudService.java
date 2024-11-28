package com.abbos.postproject.service;

import com.abbos.postproject.dto.DTO;
import com.abbos.postproject.dto.Response;
import com.abbos.postproject.entity.Auditable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:25
 **/
public interface GenericCrudService<
        ID extends Serializable,
        E extends Auditable,
        R extends DTO,
        CD extends DTO,
        UD extends DTO
        > extends GenericService, GenericQueryService<ID, E, R> {

    Response<R> create(@NotNull CD dto);

    Response<Boolean> update(@NotNull UD dto);

    Response<Boolean> delete(@NotNull ID id);

}
