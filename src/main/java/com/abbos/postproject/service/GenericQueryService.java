package com.abbos.postproject.service;

import com.abbos.postproject.dto.DTO;
import com.abbos.postproject.dto.Response;
import com.abbos.postproject.entity.Auditable;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:26
 **/
public interface GenericQueryService<
        ID extends Serializable,
        E extends Auditable,
        R extends DTO
        > {

    Response<R> find(@NotNull ID id);

    Response<List<R>> findAll();

    default <T> T find(@NotNull ID id, @NotNull Class<T> clazz) {
        return null;
    }
}

