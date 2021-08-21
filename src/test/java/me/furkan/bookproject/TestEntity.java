package me.furkan.bookproject;

import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.model.Author;
import me.furkan.bookproject.model.Book;
import me.furkan.bookproject.model.BookType;

import java.time.LocalDateTime;

public class TestEntity {

    public Book generateBook() {

        return new Book(1L, new Author(1, "test", null), "name" , "description", BookType.ADVENTURE, 1,1,2000, LocalDateTime.now());
    }

    public BookDto generateBookDto() {
        Book book = generateBook();
        return new BookDto(book.getId(), book.getName(), book.getDescription(), book.getType(), book.getAuthor(), book.getRateAmount(), book.getPageAmount(), book.getPublishingYear(), book.getCreatedTime());
    }
}
