package me.furkan.bookproject.repository;

import me.furkan.bookproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
    Optional<Book> findById(long id);

}
