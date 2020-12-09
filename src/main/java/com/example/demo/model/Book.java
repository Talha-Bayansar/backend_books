package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Min(value = 1, message = "Book price should have a minimum price of 1.")
    @Max(value = 50, message = "Book price should have a maximum price of 50.")
    private Integer price;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
