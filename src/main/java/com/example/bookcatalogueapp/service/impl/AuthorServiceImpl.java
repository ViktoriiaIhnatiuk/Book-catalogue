package com.example.bookcatalogueapp.service.impl;

import com.example.bookcatalogueapp.dto.request.AuthorRequestDto;
import com.example.bookcatalogueapp.dto.response.AuthorResponseDto;
import com.example.bookcatalogueapp.dto.response.MostSuccessfulAuthorResponseDto;
import com.example.bookcatalogueapp.mapper.RequestDtoMapper;
import com.example.bookcatalogueapp.mapper.ResponseDtoMapper;
import com.example.bookcatalogueapp.model.Author;
import com.example.bookcatalogueapp.repository.AuthorRepository;
import com.example.bookcatalogueapp.service.AuthorService;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ResponseDtoMapper<AuthorResponseDto, Author> authorResponseDtoMapper;
    private final RequestDtoMapper<AuthorRequestDto, Author> authorRequestDtoMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             ResponseDtoMapper<AuthorResponseDto, Author> authorResponseDtoMapper,
                             RequestDtoMapper<AuthorRequestDto, Author> authorRequestDtoMapper) {
        this.authorRepository = authorRepository;
        this.authorResponseDtoMapper = authorResponseDtoMapper;
        this.authorRequestDtoMapper = authorRequestDtoMapper;
    }

    @Override
    public AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto) {
        return authorResponseDtoMapper.mapToDto(authorRepository.save(
                authorRequestDtoMapper.mapToModel(authorRequestDto)));
    }

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto getAuthorById(Long id) {
        return authorResponseDtoMapper.mapToDto(authorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find author by id: " + id)));
    }

    @Override
    public AuthorResponseDto updateAuthorById(Long id, Author author) {
        Author authorToUpdate = authorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find author by id: " + id));
        if (author.getAuthorName() != null) {
            authorToUpdate.setAuthorName(author.getAuthorName());
        }
        if (author.getPhone() != null) {
            authorToUpdate.setPhone(author.getPhone());
        }
        if (author.getEmail() != null) {
            authorToUpdate.setEmail(author.getEmail());
        }
        return authorResponseDtoMapper.mapToDto(authorRepository.save(authorToUpdate));
    }

    @Override
    public AuthorResponseDto deleteAuthorById(Long id) {
        AuthorResponseDto deletedAuthor = authorResponseDtoMapper.mapToDto(
                authorRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Can't find author by id: " + id)));
        authorRepository.deleteById(id);
        return deletedAuthor;
    }

    public MostSuccessfulAuthorResponseDto getMostSuccessfulAuthor() throws SQLException {
        MostSuccessfulAuthorResponseDto mostSuccessfulAuthor =
                new MostSuccessfulAuthorResponseDto();
        mostSuccessfulAuthor.setAuthorName(authorRepository.getMostSuccessfulAuthorName());
        mostSuccessfulAuthor.setRating(authorRepository.getMostSuccessfulAuthorRating());
        return mostSuccessfulAuthor;
    }
}
