package me.furkan.bookproject.repository;

import me.furkan.bookproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByName(String name);
    Optional<Author> findById(int id);
}
