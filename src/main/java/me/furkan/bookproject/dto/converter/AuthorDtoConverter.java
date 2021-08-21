package me.furkan.bookproject.dto.converter;

import me.furkan.bookproject.dto.AuthorDto;
import me.furkan.bookproject.model.Author;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class AuthorDtoConverter implements Converter<Author, AuthorDto> {
    private final ModelMapper modelMapper;
    private final BookDtoConverter bookDtoConverter;

    public AuthorDtoConverter(ModelMapper modelMapper, BookDtoConverter bookDtoConverter) {
        this.modelMapper = modelMapper;
        this.bookDtoConverter = bookDtoConverter;
    }

    @Override
    public AuthorDto convertToDto(Author entity) {
        AuthorDto authorDto = modelMapper.map(entity, AuthorDto.class);
        if(entity.getBooks() != null) {
            authorDto.setBooks(entity.getBooks().stream().map(bookDtoConverter::convertToDto).collect(Collectors.toList()));
        }

        return authorDto;
    }

    @Override
    public Author convertToEntity(AuthorDto dto) {
        Author author = modelMapper.map(dto, Author.class);
        if(dto.getBooks() != null) {
            author.setBooks(dto.getBooks().stream().map(bookDtoConverter::convertToEntity).collect(Collectors.toList()));
        }


        return author;
    }
}
