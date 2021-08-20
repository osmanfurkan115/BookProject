package me.furkan.bookproject.dto.converter;

import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.model.Book;
import me.furkan.bookproject.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter implements Converter<Book, BookDto> {
    private final ModelMapper modelMapper;
    private final AuthorService authorService;

    public BookDtoConverter(ModelMapper modelMapper, AuthorService authorService) {
        this.modelMapper = modelMapper;
        this.authorService = authorService;
    }


    @Override
    public BookDto convertToDto(Book entity) {
        BookDto bookDto = modelMapper.map(entity, BookDto.class);
        bookDto.setAuthorName(entity.getAuthor().getName());
        return bookDto;
    }

    @Override
    public Book convertToEntity(BookDto dto) {
        Book book = modelMapper.map(dto, Book.class);
        book.setAuthor(authorService.getAuthorByName(dto.getAuthorName()));

        return book;
    }
}
