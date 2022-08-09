package com.example.bookcatalogueapp.repository;

import com.example.bookcatalogueapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT author_name FROM (SELECT author_name, "
            + "MAX(success_book_rate / books_quantity) "
            + "as success_author_rate "
            + "FROM (SELECT author_name, COUNT(book_name) as books_quantity, "
            + "SUM(sold_amount / published_amount) as success_book_rate "
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "GROUP BY author_name) as books_rate) as q;", nativeQuery = true)
    String getMostSuccessfulAuthorName();

    @Query(value = "SELECT MAX(success_book_rate / books_quantity) as success_author_rate "
            + "FROM (SELECT author_name, COUNT(book_name) as books_quantity, "
            + "SUM(sold_amount / published_amount) as success_book_rate "
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "GROUP BY author_name) as books_rate;", nativeQuery = true)
    Double getMostSuccessfulAuthorRating();
}
