package com.example.bookcatalogueapp.service;

import com.example.bookcatalogueapp.dto.request.AuthorRequestDto;
import com.example.bookcatalogueapp.dto.response.AuthorResponseDto;
import com.example.bookcatalogueapp.dto.response.MostSuccessfulAuthorResponseDto;
import com.example.bookcatalogueapp.model.Author;
import java.sql.SQLException;
import java.util.List;

public interface AuthorService {
    AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto);

    List<AuthorResponseDto> getAllAuthors();

    AuthorResponseDto getAuthorById(Long id);

    AuthorResponseDto updateAuthorById(Long id, Author author);

    AuthorResponseDto deleteAuthorById(Long id);

    MostSuccessfulAuthorResponseDto getMostSuccessfulAuthor() throws SQLException;
}
