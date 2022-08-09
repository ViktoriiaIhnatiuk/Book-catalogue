package com.example.bookcatalogueapp.service;

import com.example.bookcatalogueapp.dto.request.BookRequestDto;
import com.example.bookcatalogueapp.dto.response.BookResponseDto;
import com.example.bookcatalogueapp.model.Book;
import java.util.List;

public interface BookService {
    BookResponseDto createBook(BookRequestDto bookRequestDto);

    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    BookResponseDto updateBookById(Long id, Book book);

    BookResponseDto deleteBookById(Long id);

    List<BookResponseDto> getAllBooksByAuthorName(String authorName);

    BookResponseDto getMostSellingBookByAuthorName(String authorName);

    BookResponseDto getMostPublishedBookByAuthorName(String authorName);

    List<BookResponseDto> getMostSellingBooksByAuthorNamePartial(String authorNamePart);

    List<BookResponseDto> getMostPublishedBooksByAuthorNamePartial(String authorNamePart);

    List<BookResponseDto> getMostSuccessfulBooksByAuthorNamePartial(String authorNamePart);

    List<Book> getTopSellingBooksByAuthorNamePartial(String authorNamePart, Long booksQuantity);

    List<Book> getTopPublishedBooksByAuthorName(String authorName, Long booksQuantity);

    List<Book> getTopSuccessfulBooksByAuthorName(String authorName, Long booksQuantity);
}
