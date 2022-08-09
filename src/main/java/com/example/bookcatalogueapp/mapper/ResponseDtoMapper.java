package com.example.bookcatalogueapp.mapper;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M model);
}
