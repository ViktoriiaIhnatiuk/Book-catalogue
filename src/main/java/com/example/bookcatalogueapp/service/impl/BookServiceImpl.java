package com.example.bookcatalogueapp.service.impl;

import com.example.bookcatalogueapp.dto.request.BookRequestDto;
import com.example.bookcatalogueapp.dto.response.BookResponseDto;
import com.example.bookcatalogueapp.mapper.RequestDtoMapper;
import com.example.bookcatalogueapp.mapper.ResponseDtoMapper;
import com.example.bookcatalogueapp.model.Book;
import com.example.bookcatalogueapp.repository.AuthorRepository;
import com.example.bookcatalogueapp.repository.BookRepository;
import com.example.bookcatalogueapp.service.BookService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ResponseDtoMapper<BookResponseDto, Book> bookResponseDtoMapper;
    private final RequestDtoMapper<BookRequestDto, Book> bookRequestDtoMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           ResponseDtoMapper<BookResponseDto, Book> bookResponseDtoMapper,
                           RequestDtoMapper<BookRequestDto, Book> bookRequestDtoMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookResponseDtoMapper = bookResponseDtoMapper;
        this.bookRequestDtoMapper = bookRequestDtoMapper;
    }

    @Override
    public BookResponseDto createBook(BookRequestDto bookRequestDto) {
        return bookResponseDtoMapper.mapToDto(
               bookRepository.save(bookRequestDtoMapper.mapToModel(bookRequestDto)));
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        return bookResponseDtoMapper.mapToDto(bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find book by id: " + id)));
    }

    @Override
    public BookResponseDto updateBookById(Long id, Book book) {
        Book bookToUpdate = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find book by id: " + id));
        if (book.getBookName() != null) {
            bookToUpdate.setBookName(book.getBookName());
        }
        if (book.getAuthorId() != null) {
            bookToUpdate.setAuthorId(book.getAuthorId());
        }
        if (book.getPublishedAmount() != null) {
            bookToUpdate.setPublishedAmount(book.getPublishedAmount());
        }
        if (book.getSoldAmount() != null) {
            bookToUpdate.setSoldAmount(book.getSoldAmount());
        }
        return bookResponseDtoMapper.mapToDto(bookRepository.save(bookToUpdate));
    }

    @Override
    public BookResponseDto deleteBookById(Long id) {
        BookResponseDto deletedBook = bookResponseDtoMapper.mapToDto(
                bookRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("Can't find book by id: " + id)));
        bookRepository.deleteById(id);
        return deletedBook;
    }

    @Override
    public List<BookResponseDto> getAllBooksByAuthorName(String authorName) {
        return bookRepository.getAllBookByAuthorName(authorName).stream()
                .map(bookResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getMostSellingBookByAuthorName(String authorName) {
        return bookResponseDtoMapper.mapToDto(bookRepository
               .getMostSellingBookByAuthorName(authorName)
               .orElseThrow(() -> new RuntimeException("Can't find any books by author name "
                       + authorName)));
    }

    @Override
    public BookResponseDto getMostPublishedBookByAuthorName(String authorName) {
        return bookResponseDtoMapper.mapToDto(bookRepository
               .getMostPublishedBookByAuthorName(authorName)
               .orElseThrow(() -> new RuntimeException("Can't find any books by author name "
                       + authorName)));
    }

    public List<BookResponseDto> getMostSellingBooksByAuthorNamePartial(String authorNamePart) {
        return bookRepository.getMostSellingBooksByAuthorNamePartial(authorNamePart).stream()
                .map(bookResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<BookResponseDto> getMostPublishedBooksByAuthorNamePartial(String authorNamePart) {
        return bookRepository.getMostPublishedBooksByAuthorNamePartial(authorNamePart).stream()
                .map(bookResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<BookResponseDto> getMostSuccessfulBooksByAuthorNamePartial(String authorNamePart) {
        return bookRepository.getMostSuccessfulBooksByAuthorNamePartial(authorNamePart).stream()
                .map(bookResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<Book> getTopSellingBooksByAuthorNamePartial(String authorNamePart,
                                                            Long booksQuantity) {
        return bookRepository.getTopSellingBooksByAuthorNamePartial(authorNamePart, booksQuantity);
    }

    public List<Book> getTopPublishedBooksByAuthorName(String authorName,
                                                       Long booksQuantity) {
        return bookRepository.getTopPublishedBooksByAuthorName(authorName,
                booksQuantity);
    }

    public List<Book> getTopSuccessfulBooksByAuthorName(String authorName, Long booksQuantity) {
        return bookRepository.getTopSuccessfulBooksByAuthorName(authorName, booksQuantity);
    }
}
