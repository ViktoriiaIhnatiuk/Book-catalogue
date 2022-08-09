package com.example.bookcatalogueapp.controller;

import com.example.bookcatalogueapp.dto.request.BookRequestDto;
import com.example.bookcatalogueapp.dto.response.BookResponseDto;
import com.example.bookcatalogueapp.mapper.RequestDtoMapper;
import com.example.bookcatalogueapp.model.Book;
import com.example.bookcatalogueapp.service.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final RequestDtoMapper<BookRequestDto, Book> bookRequestDtoMapper;

    public BookController(BookService bookService,
                          RequestDtoMapper<BookRequestDto, Book> bookRequestDtoMapper) {
        this.bookService = bookService;
        this.bookRequestDtoMapper = bookRequestDtoMapper;
    }

    @PostMapping
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBookById(@PathVariable Long id,
                                          @RequestBody BookRequestDto bookRequestDto) {
        return bookService.updateBookById(id, bookRequestDtoMapper.mapToModel(bookRequestDto));
    }

    @DeleteMapping("/{id}")
    public BookResponseDto deleteBookById(@PathVariable Long id) {
        return bookService.deleteBookById(id);
    }

    @GetMapping("/by-author")
    public List<BookResponseDto> getAllBooksByAuthorName(@RequestParam String authorName) {
        return bookService.getAllBooksByAuthorName(authorName);
    }

    @GetMapping("/most-selling")
    public BookResponseDto getMostSellingBookByAuthorName(@RequestParam String authorName) {
        return bookService.getMostSellingBookByAuthorName(authorName);
    }

    @GetMapping("/most-published")
    public BookResponseDto getMostPublishedBookByAuthorName(@RequestParam String authorName) {
        return bookService.getMostPublishedBookByAuthorName(authorName);
    }

    @GetMapping("/most-selling/by-author-name-partial")
    public List<BookResponseDto> getMostSellingBooksByAuthorNamePartial(
            @RequestParam String authorNamePart) {
        return bookService.getMostSellingBooksByAuthorNamePartial(authorNamePart);
    }

    @GetMapping("/most-published/by-author-name-partial")
    public List<BookResponseDto> getMostPublishedBooksByAuthorNamePartial(
            @RequestParam String authorNamePart) {
        return bookService.getMostPublishedBooksByAuthorNamePartial(authorNamePart);
    }

    @GetMapping("/most-successful")
    public List<BookResponseDto> getMostSuccessfulBooksByAuthorNamePartial(String authorNamePart) {
        return bookService.getMostSuccessfulBooksByAuthorNamePartial(authorNamePart);
    }

    @GetMapping("/top-selling/by-author")
    public List<Book> getTopSellingBooksByAuthorName(@RequestParam String authorName,
                                                            @RequestParam Long booksQuantity) {
        return bookService.getTopSellingBooksByAuthorNamePartial(authorName, booksQuantity);
    }

    @GetMapping("/top-published/by-author")
    public List<Book> getTopPublishedBooksByAuthorName(@RequestParam String authorName,
                                                            @RequestParam Long booksQuantity) {
        return bookService.getTopSellingBooksByAuthorNamePartial(authorName, booksQuantity);
    }

    @GetMapping("/top-successful/by-author")
    public List<Book> getTopSuccessfulBooksByAuthorName(@RequestParam String authorName,
                                                              @RequestParam Long booksQuantity) {
        return bookService.getTopSellingBooksByAuthorNamePartial(authorName, booksQuantity);
    }
}

