package com.example.bookcatalogueapp.repository;

import com.example.bookcatalogueapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
