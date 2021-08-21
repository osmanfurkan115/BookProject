package me.furkan.bookproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","author"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @NotBlank
    private String name;

    @NotBlank
    @Column(length = 2048)
    private String description;

    @NotNull
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
