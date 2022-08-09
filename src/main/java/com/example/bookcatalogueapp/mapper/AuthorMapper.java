package com.example.bookcatalogueapp.mapper;

import com.example.bookcatalogueapp.dto.request.AuthorRequestDto;
import com.example.bookcatalogueapp.dto.response.AuthorResponseDto;
import com.example.bookcatalogueapp.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements RequestDtoMapper<AuthorRequestDto, Author>,
        ResponseDtoMapper<AuthorResponseDto, Author> {
    @Override
    public Author mapToModel(AuthorRequestDto dto) {
        Author author = new Author();
        author.setAuthorName(dto.getAuthorName());
        author.setEmail(dto.getEmail());
        author.setPhone(author.getPhone());
        return author;
    }

    @Override
    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setAuthorName(author.getAuthorName());
        authorResponseDto.setEmail(author.getEmail());
        authorResponseDto.setPhone(author.getPhone());
        return authorResponseDto;
    }
}
