package com.example.bookcatalogueapp.controller;

import com.example.bookcatalogueapp.dto.request.AuthorRequestDto;
import com.example.bookcatalogueapp.dto.response.AuthorResponseDto;
import com.example.bookcatalogueapp.dto.response.MostSuccessfulAuthorResponseDto;
import com.example.bookcatalogueapp.mapper.RequestDtoMapper;
import com.example.bookcatalogueapp.model.Author;
import com.example.bookcatalogueapp.service.AuthorService;
import java.sql.SQLException;
import java.util.List;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Create a new author")
    public AuthorResponseDto createAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.createAuthor(authorRequestDto);
    }

    @GetMapping
    @ApiOperation(value = "Display all authors")
    public List<AuthorResponseDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Display an author by author's id")
    public AuthorResponseDto getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping ("/{id}")
    @ApiOperation(value = "Update an author by author's id")
    public AuthorResponseDto updateAuthorById(@PathVariable Long id,
                                              @RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.updateAuthorById(id,
                authorRequestDtoMapper.mapToModel(authorRequestDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an author by author's id")
    public AuthorResponseDto deleteAuthorById(@PathVariable Long id) {
        return authorService.deleteAuthorById(id);
    }

    @GetMapping("/most-successful")
    @ApiOperation(value = "Display the most successful author (successAuthorRate = sum of all " +
            "successBookRate/number of books) with author's successAuthorRate")
    public MostSuccessfulAuthorResponseDto getMostSuccessfulAuthor() throws SQLException {
        return authorService.getMostSuccessfulAuthor();
    }
}
