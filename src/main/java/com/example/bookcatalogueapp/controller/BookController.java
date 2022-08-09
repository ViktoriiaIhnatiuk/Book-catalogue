package com.example.bookcatalogueapp.controller;

import com.example.bookcatalogueapp.dto.request.BookRequestDto;
import com.example.bookcatalogueapp.dto.response.BookResponseDto;
import com.example.bookcatalogueapp.mapper.RequestDtoMapper;
import com.example.bookcatalogueapp.model.Book;
import com.example.bookcatalogueapp.service.BookService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Create a new book")
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }

    @GetMapping
    @ApiOperation("Display all books")
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @ApiOperation("Display a book by id")
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update a book by id")
    public BookResponseDto updateBookById(@PathVariable Long id,
                                          @RequestBody BookRequestDto bookRequestDto) {
        return bookService.updateBookById(id, bookRequestDtoMapper.mapToModel(bookRequestDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a book by id")
    public BookResponseDto deleteBookById(@PathVariable Long id) {
        return bookService.deleteBookById(id);
    }

    @GetMapping("/by-author")
    @ApiOperation("Display all books by author's name")
    public List<BookResponseDto> getAllBooksByAuthorName(@RequestParam String authorName) {
        return bookService.getAllBooksByAuthorName(authorName);
    }

    @GetMapping("/most-selling")
    @ApiOperation("Display the most selling book for requested author's name")
    public BookResponseDto getMostSellingBookByAuthorName(@RequestParam String authorName) {
        return bookService.getMostSellingBookByAuthorName(authorName);
    }

    @GetMapping("/most-published")
    @ApiOperation("Display the most published book for requested author's name")
    public BookResponseDto getMostPublishedBookByAuthorName(@RequestParam String authorName) {
        return bookService.getMostPublishedBookByAuthorName(authorName);
    }

    @GetMapping("/most-selling/by-author-name-partial")
    @ApiOperation("Display a list of most selling books using partial search by author's name")
    public List<BookResponseDto> getMostSellingBooksByAuthorNamePartial(
            @RequestParam String authorNamePart) {
        return bookService.getMostSellingBooksByAuthorNamePartial(authorNamePart);
    }

    @GetMapping("/most-published/by-author-name-partial")
    @ApiOperation("Display a list of most published books using partial search by author's name")
    public List<BookResponseDto> getMostPublishedBooksByAuthorNamePartial(
            @RequestParam String authorNamePart) {
        return bookService.getMostPublishedBooksByAuthorNamePartial(authorNamePart);
    }

    @GetMapping("/most-successful")
    @ApiOperation("Display a list of most successful books using partial search by author's name"
            + " (successBookRate = soldAmount/publishedAmount)")
    public List<BookResponseDto> getMostSuccessfulBooksByAuthorNamePartial(String authorNamePart) {
        return bookService.getMostSuccessfulBooksByAuthorNamePartial(authorNamePart);
    }

    @GetMapping("/top-selling/by-author")
    @ApiOperation("Display TOP N most-selling books by concrete author's name")
    public List<Book> getTopSellingBooksByAuthorName(@RequestParam String authorName,
                                                            @RequestParam Long booksQuantity) {
        return bookService.getTopSellingBooksByAuthorNamePartial(authorName, booksQuantity);
    }

    @GetMapping("/top-published/by-author")
    @ApiOperation("Display TOP N most-published books by concrete author's name")
    public List<Book> getTopPublishedBooksByAuthorName(@RequestParam String authorName,
                                                            @RequestParam Long booksQuantity) {
        return bookService.getTopSellingBooksByAuthorNamePartial(authorName, booksQuantity);
    }

    @GetMapping("/top-successful/by-author")
    @ApiOperation("Display TOP N most-successful books by concrete author's name")
    public List<Book> getTopSuccessfulBooksByAuthorName(@RequestParam String authorName,
                                                              @RequestParam Long booksQuantity) {
        return bookService.getTopSellingBooksByAuthorNamePartial(authorName, booksQuantity);
    }
}
