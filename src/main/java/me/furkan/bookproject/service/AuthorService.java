package me.furkan.bookproject.service;

import me.furkan.bookproject.dto.AuthorDto;
import me.furkan.bookproject.dto.converter.AuthorDtoConverter;
import me.furkan.bookproject.exception.AuthorNotFoundException;
import me.furkan.bookproject.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDtoConverter authorDtoConverter;

    public AuthorService(AuthorRepository authorRepository, AuthorDtoConverter authorDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorDtoConverter = authorDtoConverter;
    }

    public AuthorDto getAuthorByName(String name) {
        return authorDtoConverter.convertToDto(authorRepository.findByName(name).orElseThrow(() -> new AuthorNotFoundException("Couldn't find an author with name: " + name)));
    }
}
