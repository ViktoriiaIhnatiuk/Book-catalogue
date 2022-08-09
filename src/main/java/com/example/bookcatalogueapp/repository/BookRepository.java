package com.example.bookcatalogueapp.repository;

import com.example.bookcatalogueapp.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name = ?;", nativeQuery = true)
    List<Book> getAllBookByAuthorName(String authorName);

    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name = ? "
            + "ORDER BY b.sold_amount DESC "
            + "LIMIT 1;", nativeQuery = true)
    Optional<Book> getMostSellingBookByAuthorName(String authorName);

    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name = ? "
            + "ORDER BY b.published_amount DESC "
            + "LIMIT 1;", nativeQuery = true)
    Optional<Book> getMostPublishedBookByAuthorName(String authorName);

    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name LIKE %?% "
            + "GROUP BY author_name "
            + "ORDER BY b.sold_amount DESC", nativeQuery = true)
    List<Book> getMostSellingBooksByAuthorNamePartial(String authorNamePart);

    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name LIKE %?% "
            + "GROUP BY author_name "
            + "ORDER BY b.published_amount DESC", nativeQuery = true)
    List<Book> getMostPublishedBooksByAuthorNamePartial(String authorNamePart);

    @Query(value = "SELECT DISTINCT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name LIKE %?% "
            + "GROUP BY author_name "
            + "ORDER BY (b.sold_amount/b.published_amount) DESC", nativeQuery = true)
    List<Book> getMostSuccessfulBooksByAuthorNamePartial(String authorNamePart);

    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name LIKE %?% "
            + "ORDER BY b.sold_amount DESC "
            + "LIMIT ?;", nativeQuery = true)
    List<Book> getTopSellingBooksByAuthorNamePartial(String authorName, Long booksQuantity);

    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name LIKE %?% "
            + "ORDER BY b.published_amount DESC "
            + "LIMIT ?;", nativeQuery = true)
    List<Book> getTopPublishedBooksByAuthorName(String authorName, Long booksQuantity);

    @Query(value = "SELECT*"
            + "FROM books b "
            + "LEFT JOIN authors a "
            + "ON b.author_id = a.id "
            + "WHERE a.author_name LIKE %?% "
            + "ORDER BY (b.sold_amount/b.published_amount) DESC "
            + "LIMIT ?;", nativeQuery = true)
    List<Book> getTopSuccessfulBooksByAuthorName(String authorName, Long booksQuantity);
}
