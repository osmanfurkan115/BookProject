package me.furkan.bookproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.furkan.bookproject.model.BookType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String description;
    private BookType type;
    private String authorName;
    private int rateAmount;
    private int pageAmount;
    private int publishingYear;
    private LocalDateTime createdTime;
}
