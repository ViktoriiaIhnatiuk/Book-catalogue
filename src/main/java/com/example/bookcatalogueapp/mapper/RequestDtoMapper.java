package com.example.bookcatalogueapp.mapper;

public interface RequestDtoMapper<D, M> {
    M mapToModel(D dto);
}
