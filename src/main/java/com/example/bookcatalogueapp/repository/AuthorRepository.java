package com.example.bookcatalogueapp.repository;

import com.example.bookcatalogueapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
