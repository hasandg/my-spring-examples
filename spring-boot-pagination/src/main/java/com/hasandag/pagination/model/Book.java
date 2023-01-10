package com.hasandag.pagination.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "books")
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publishDate;
}
