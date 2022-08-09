package com.example.bookcatalogueapp.mapper;

import com.example.bookcatalogueapp.dto.request.BookRequestDto;
import com.example.bookcatalogueapp.dto.response.BookResponseDto;
import com.example.bookcatalogueapp.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements RequestDtoMapper<BookRequestDto, Book>,
        ResponseDtoMapper<BookResponseDto, Book> {

    @Override
    public Book mapToModel(BookRequestDto dto) {
        Book book = new Book();
        book.setBookName(dto.getBookName());
        book.setAuthorId(dto.getAuthorId());
        book.setPublishedAmount(dto.getPublishedAmount());
        book.setSoldAmount(dto.getSoldAmount());
        return book;
    }

    @Override
    public BookResponseDto mapToDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setBookName(book.getBookName());
        bookResponseDto.setAuthorId(book.getAuthorId());
        bookResponseDto.setPublishedAmount(book.getPublishedAmount());
        bookResponseDto.setSoldAmount(book.getSoldAmount());
        return bookResponseDto;
    }
}
