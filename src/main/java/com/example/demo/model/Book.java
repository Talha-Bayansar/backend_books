package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_seq", initialValue = 0, allocationSize = 1)
    private Integer id;

    @NotBlank(message = "Book title should not be blank.")
    @NotNull(message = "Book title should not be null.")
    private String title;

    @NotBlank(message = "Book author should not be blank.")
    @NotNull(message = "Book author should not be null.")
    private String author;

    @Min(value = 0, message = "Book price should have a minimum price of 1.")
    @Max(value = 2000, message = "Book price should have a maximum price of 50.")
    private Integer priceInEuro;

}
