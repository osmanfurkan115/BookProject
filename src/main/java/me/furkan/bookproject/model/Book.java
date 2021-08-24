package me.furkan.bookproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

//@Entity
@Document(indexName = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id", nullable = false)
//    @Field(type = FieldType.Nested)
    private Author author;

    @NotBlank
    @Field(type = FieldType.Keyword)
    private String name;

    @NotBlank
    @Size(max = 2048)
    @Field(type = FieldType.Keyword)
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
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private LocalDateTime createdTime = LocalDateTime.now();
}
