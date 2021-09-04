package me.furkan.bookproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 2048)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BookType type;

    @PositiveOrZero
    private int rateAmount;

    @PositiveOrZero
    private int pageAmount;

    @PositiveOrZero
    private int publishingYear;

    @NotNull
    private LocalDateTime createdTime = LocalDateTime.now();
}
