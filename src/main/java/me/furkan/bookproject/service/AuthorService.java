package me.furkan.bookproject.service;

import me.furkan.bookproject.dto.AuthorDto;
import me.furkan.bookproject.dto.converter.AuthorDtoConverter;
import me.furkan.bookproject.exception.AuthorNotFoundException;
import me.furkan.bookproject.model.Author;
import me.furkan.bookproject.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDtoConverter authorDtoConverter;

    public AuthorService(AuthorRepository authorRepository, AuthorDtoConverter authorDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorDtoConverter = authorDtoConverter;
    }

    public AuthorDto save(AuthorDto author) {
        return authorDtoConverter.convertToDto(authorRepository.save(authorDtoConverter.convertToEntity(author)));
    }

    public AuthorDto getAuthorByName(String name) {
        return authorDtoConverter.convertToDto(authorRepository.findByName(name).orElseThrow(() -> new AuthorNotFoundException("Couldn't find an author with name: " + name)));
    }
    public AuthorDto getAuthorById(int id) {
        return authorDtoConverter.convertToDto(authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Couldn't find an author with id: " + id)));
    }

    public List<AuthorDto> getAll() {
        return authorRepository.findAll().stream().map(authorDtoConverter::convertToDto).collect(Collectors.toList());
    }
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        final Author author = authorRepository.save(authorDtoConverter.convertToEntity(authorDto));
        return authorDtoConverter.convertToDto(authorRepository.save(author));
    }
}
