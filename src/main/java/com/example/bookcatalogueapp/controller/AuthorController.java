package com.example.bookcatalogueapp.controller;

import com.example.bookcatalogueapp.dto.request.AuthorRequestDto;
import com.example.bookcatalogueapp.dto.response.AuthorResponseDto;
import com.example.bookcatalogueapp.dto.response.MostSuccessfulAuthorResponseDto;
import com.example.bookcatalogueapp.mapper.RequestDtoMapper;
import com.example.bookcatalogueapp.model.Author;
import com.example.bookcatalogueapp.service.AuthorService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final RequestDtoMapper<AuthorRequestDto, Author> authorRequestDtoMapper;

    public AuthorController(AuthorService authorService,
                            RequestDtoMapper<AuthorRequestDto, Author> authorRequestDtoMapper) {
        this.authorService = authorService;
        this.authorRequestDtoMapper = authorRequestDtoMapper;
    }

    @PostMapping
    public AuthorResponseDto createAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.createAuthor(authorRequestDto);
    }

    @GetMapping
    public List<AuthorResponseDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorResponseDto getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping ("/{id}")
    public AuthorResponseDto updateAuthorById(@PathVariable Long id,
                                              @RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.updateAuthorById(id,
                authorRequestDtoMapper.mapToModel(authorRequestDto));
    }

    @DeleteMapping("/{id}")
    public AuthorResponseDto deleteAuthorById(@PathVariable Long id) {
        return authorService.deleteAuthorById(id);
    }

    @GetMapping("/most-successful")
    public MostSuccessfulAuthorResponseDto getMostSuccessfulAuthor() throws SQLException {
        return authorService.getMostSuccessfulAuthor();
    }
}
