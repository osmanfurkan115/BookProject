package me.furkan.bookproject.service;

import me.furkan.bookproject.exception.AuthorNotFoundException;
import me.furkan.bookproject.model.Author;
import me.furkan.bookproject.repository.AuthorRepository;

public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name).orElseThrow(() -> new AuthorNotFoundException("Couldn't find an author with name: " + name));
    }
}
