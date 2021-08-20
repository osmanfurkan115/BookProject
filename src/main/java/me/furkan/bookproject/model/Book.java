package me.furkan.bookproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private BookType type;

    @PositiveOrZero
    private int rateAmount;

    @PositiveOrZero
    private int pageAmount;

    @PositiveOrZero
    private int publishingYear;

    private LocalDateTime createdTime = LocalDateTime.now();
}
